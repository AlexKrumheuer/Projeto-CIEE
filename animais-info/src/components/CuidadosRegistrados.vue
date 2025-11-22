<script setup>
import { defineProps, defineEmits, onMounted, ref } from 'vue';
const props = defineProps({
    componenteInfo: {
        type: Object,
        required: true,
    },
})

const emit = defineEmits(['alterar-valor', 'editar-cuidado-emit'])

let cuidados = ref([])
let carregando = ref(true)

async function carregarCuidados() {
    try {
        const resposta = await fetch("http://localhost:8080/api/cuidados")
        if (resposta.ok) {
            cuidados.value = await resposta.json()
            console.log("cuidados carregado com sucesso")
        } else {
            console.error("Não foi possível buscar os cuidados")
        }
    } catch (err) {
        console.error("Não foi possível carregar os cuidados")
    } finally {
        carregando.value = false
    }
}

onMounted(() => {
    carregarCuidados();
})

function handleButtonAddClick() {
    emit('alterar-valor')
}

async function excluirCuidado(id) {
    const confirmar = confirm("Tem certeza que deseja excluir esse cuidado?")
    if(!confirmar) return
    try {
        const resposta = await fetch(`http://localhost:8080/api/cuidados/${id}`, {
            method: "DELETE",
        })
        if(resposta.ok) {
            alert("Cuidado excluído com sucesso")
            carregarCuidados()
        }
    } catch (err) {
        console.error("Erro ao excluir cuidado")
    }
}

function editarCuidado(cuidado) {
    emit('editar-cuidado-emit', cuidado)
}

</script>
<template>
    <section class="content">
        <div class="header">
            <h1>{{ props.componenteInfo.titulo }}</h1>
            <button v-on:click="handleButtonAddClick" class="button">
                <fa icon="plus" />
                {{ props.componenteInfo.botaoAdicionar }}
            </button>
        </div>
        <p v-if="carregando">Carregando dados...</p>
        <p v-else-if="cuidados.length === 0">Nenhum animal encontrado</p>
        <div v-else class="wrapper-table">
            <table class="table">
                <thead class="table-head">
                    <tr>
                        <th>{{ props.componenteInfo.tableHeader.primeiraColuna }}</th>
                        <th>{{ props.componenteInfo.tableHeader.segundaColuna }}</th>
                        <th>{{ props.componenteInfo.tableHeader.terceiraColuna }}</th>
                        <th>{{ props.componenteInfo.tableHeader.quartaColuna }}</th>
                    </tr>
                </thead>
                <tbody class="table-body">
                    <tr v-for="cuidado in cuidados" :key="cuidado.id">
                        <td>{{ cuidado.nome }}</td>
                        <td>{{ cuidado.descricao }}</td>
                        <td>{{ cuidado.duracao }} min</td>
                        <td class="actions">
                            <fa class="edit" icon="pen" v-on:click="editarCuidado(cuidado)" />
                            <fa class="trash" icon="trash" v-on:click="excluirCuidado(cuidado.id)" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </section>
</template>
<style>
.content {
    padding: 3rem;
    background-color: #fff;
    min-width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    gap: 2rem;
    border-radius: 8px;
    overflow: hidden;
}

.header {
    display: flex;
    justify-content: space-between;
}

.wrapper-table {
    overflow-y: auto;
    flex: 1;
}

.table {
    width: 100%;
    border-collapse: collapse;
}

.table-head {
    background-color: #04AA6D;
    color: #fff;
}

.table-head tr th {
    padding: 0.5rem;
    font-size: 0.8rem;
    position: sticky;
    z-index: 1;
    top: 0;
    background-color: #04AA6D;
}

.table-body {
    height: 100%;
    overflow-y: auto;
}

.table-body tr td {
    padding: 1rem;
    text-align: center;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

.button {
    background-color: #28b187;
    color: #fff;
    cursor: pointer;
    padding: 0.6rem;
    border: none;
    font-size: 0.9rem;
    font-weight: bold;
    border-radius: 18px;
    transition: 0.25s;
    border: 1px solid transparent;
}

.button:hover {
    background-color: #fff;
    border: 1px solid #28b187;
    color: #28b187;
}

.actions {
    display: flex;
    gap: 0.5rem;
    padding: 0.5rem;
}

.edit,
.trash {
    cursor: pointer;
    color: #fff;
    padding: 0.3rem;
    border-radius: 50%;
    transition: 0.25s;
    border: 1px solid transparent;
}

.edit {
    background-color: #1591EA;
}

.trash {
    color: #fff;
    background-color: red;
    padding: 0.3rem;
    border-radius: 50%;
}

.edit:hover {
    color: #1591EA;
    background-color: #fff;
    border: #1591EA 1px solid;
}

.trash:hover {
    color: red;
    background-color: #fff;
    border: red 1px solid;
}
</style>
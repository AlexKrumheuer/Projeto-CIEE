<script setup>
import {defineProps, defineEmits} from 'vue';
const props = defineProps({
    componenteInfo: {
        type: Object,
        required: true,
    },
})

const emit = defineEmits(['alterar-valor'])

function handleButtonAddClick() {
    emit('alterar-valor')
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
        <table class="table">
            <thead class="table-head">
                <tr>
                    <th>{{ props.componenteInfo.tableHeader.primeiraColuna }}</th>
                    <th>{{ props.componenteInfo.tableHeader.segundaColuna }}</th>
                    <th>{{ props.componenteInfo.tableHeader.terceiraColuna }}</th>
                    <th>{{ props.componenteInfo.tableHeader.quartaColuna }}</th>
                    <th>{{ props.componenteInfo.tableHeader.quintaColuna }}</th>
                    <th v-if="!props.componenteInfo.tableHeader.sextaColuna">{{ props.componenteInfo.tableHeader.sextaColuna }}</th>
                    <th v-if="!props.componenteInfo.tableHeader.setimaColuna">{{ props.componenteInfo.tableHeader.setimaColuna }}</th> 
                </tr>
            </thead>
            <tbody class="table-body">
                <tr>
                    <td>Zeus</td>
                    <td>Cachorro de porte grande</td>
                    <td>14/05/2000</td>
                    <td>Cachorro</td>
                    <td>Doméstico</td>
                    <td>Brasil</td>
                    <td class="actions">
                        <fa class="edit" icon="pen"/>
                        <fa class="trash" icon="trash"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </section>
</template>
<style>
    .content {
        padding: 3rem;
        background-color: #fff;
        min-width: 100%;
        display: flex;
        height: auto;
        flex-direction: column;
        gap: 2rem;
        border-radius: 8px;
        overflow-y: auto;
    }

    .header {
        display: flex;
        justify-content: space-between;
    }

    .table-head {
        background-color: #04AA6D;
        color: #fff;
    }

    .table-head tr th {
        padding: 0.5rem;
        font-size: 0.8rem;
    }

    .table-body tr td {
        padding: 0.5rem;
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
<script setup>
import { ref, watch } from 'vue';
import InputPadrao from './form/InputPadrao.vue';
import ValidarCamposForm from '../util/ValidarCamposForm';

const props = defineProps({
    editarAnimalPreencherDados: {
        type: Object
    }
})

const formAnimalInfo = {
    titulo: "Criar Animal",
    botaoAdicionar: "Adicionar Animal",
    inputNomeAnimal: {
        nome: "nome",
        type: "text",
        placeholder: "Nome do animal...",
        label: "Nome do Animal"
    },
    inputEspecieAnimal: {
        nome: "especie",
        type: "text",
        placeholder: "Espécie do animal",
        label: "Espécie"
    },
    inputHabitatAnimal: {
        nome: "habit",
        type: "text",
        placeholder: "Habitat do animal...",
        label: "Habitat"
    },
    inputOrigemAimal: {
        nome: "origem",
        type: "text",
        placeholder: "País de origem do animal...",
        label: "País de Origem"
    },
    inputNascimentoAnimal: {
        nome: "nascimento",
        type: "date",
        placeholder: null,
        label: "Data de Nascimento"
    },
}

let nomeAnimal = ref("")
let especieAnimal = ref("")
let habitatAnimal = ref("")
let paisOrigem = ref("")
let dataNascimento = ref("")
let descricao = ref("")
let error = ref("")

function validarValoresRefCampoForm() {
    if (!ValidarCamposForm.validarTextoVazio(nomeAnimal.value)) {
        error.value = "Nome do animal deve ser fornecido"
        return false
    }
    if (!ValidarCamposForm.validarTextoVazio(especieAnimal.value)) {
        error.value = "Espécie do animal deve ser fornecida"
        return false
    }
    if (!ValidarCamposForm.validarTextoVazio(habitatAnimal.value)) {
        error.value = "Habitat do animal deve ser fornecido"
        return false
    }
    if (!ValidarCamposForm.validarTextoVazio(paisOrigem.value)) {
        error.value = "País de origem do animal deve ser fornecido"
        return false
    }
    if (!ValidarCamposForm.validarTextoVazio(dataNascimento.value)) {
        error.value = "Data de nascimento do animal deve ser fornecida"
        return false
    }
    if (!ValidarCamposForm.validarTextoVazio(descricao.value)) {
        error.value = "Descrição sobre o animal deve ser fornecida"
        return false
    }
    return true
}

async function enviarForm() {
    if (!validarValoresRefCampoForm()) return false
    if (props.editarAnimalPreencherDados) {
        const animalSalvar = {
            nome: nomeAnimal.value,
            especie: especieAnimal.value,
            habitat: habitatAnimal.value,
            origem: paisOrigem.value,
            nascimento: dataNascimento.value,
            descricao: descricao.value
        }
        try {
            const resposta = await fetch(`http://localhost:8080/api/animais/${props.editarAnimalPreencherDados.id}`,{
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(animalSalvar)
            })
             console.log("Animal editado")
            if(resposta.ok){
                nomeAnimal.value = ""
                especieAnimal.value = ""
                habitatAnimal.value = ""
                paisOrigem.value = ""
                dataNascimento.value = ""
                descricao.value = ""
                error.value = ""
                alert("Animal editado com sucesso")
                window.location.reload()
            } else {
                console.error("Erro ao editar animal")
                error.value = "Houve um erro interno ao editar o animal"
            } 
        } catch(err) {
                console.error("Impossivel editar o animal")
            }
    } else {
        const animalSalvar = {
            nome: nomeAnimal.value,
            especie: especieAnimal.value,
            habitat: habitatAnimal.value,
            origem: paisOrigem.value,
            nascimento: dataNascimento.value,
            descricao: descricao.value
        }
        console.log(animalSalvar)
        try {
            const resposta = await fetch("http://localhost:8080/api/animais", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(animalSalvar)
            })
            if (resposta.ok) {
                nomeAnimal.value = ""
                especieAnimal.value = ""
                habitatAnimal.value = ""
                paisOrigem.value = ""
                dataNascimento.value = ""
                descricao.value = ""
                error.value = ""
                alert("Animal cadastrado com sucesso")
                window.location.reload()

            } else {
                error.value = "Houve algum erro interno. Animal não cadastrado"
                console.error(await resposta.text())
            }
        } catch (erro) {
            console.error("Erro de conexão: ", erro)
        }
    }
}

watch(() => props.editarAnimalPreencherDados, (novoValor) => {
    console.log(novoValor)
    if (novoValor) {
        nomeAnimal.value = novoValor.nome
        especieAnimal.value = novoValor.especie
        habitatAnimal.value = novoValor.habitat
        paisOrigem.value = novoValor.origem
        dataNascimento.value = novoValor.nascimento
        descricao.value = novoValor.descricao
    } else {
        nomeAnimal.value = ""
        especieAnimal.value = ""
        habitatAnimal.value = ""
        paisOrigem.value = ""
        dataNascimento.value = ""
        descricao.value = ""
    }

}, { immediate: true })

</script>
<template>
    <form @submit.prevent="enviarForm" action="">
        <h2>{{ props.editarAnimalPreencherDados ? "Editar Animal" : formAnimalInfo.titulo }}</h2>
        <div class="form-campos">
            <div class="container-campo">
                <InputPadrao :label="formAnimalInfo.inputNomeAnimal.label" :type="formAnimalInfo.inputNomeAnimal.type"
                    :name="formAnimalInfo.inputNomeAnimal.nome"
                    :placeholder="formAnimalInfo.inputNomeAnimal.placeholder" v-model="nomeAnimal" />
                <InputPadrao :label="formAnimalInfo.inputEspecieAnimal.label"
                    :type="formAnimalInfo.inputEspecieAnimal.type" :name="formAnimalInfo.inputEspecieAnimal.nome"
                    :placeholder="formAnimalInfo.inputEspecieAnimal.placeholder" v-model="especieAnimal" />
            </div>
            <div class="container-campo">
                <InputPadrao :label="formAnimalInfo.inputHabitatAnimal.label"
                    :type="formAnimalInfo.inputHabitatAnimal.type" :name="formAnimalInfo.inputHabitatAnimal.nome"
                    :placeholder="formAnimalInfo.inputHabitatAnimal.placeholder" v-model="habitatAnimal" />
                <InputPadrao :label="formAnimalInfo.inputOrigemAimal.label" :type="formAnimalInfo.inputOrigemAimal.type"
                    :name="formAnimalInfo.inputOrigemAimal.nome"
                    :placeholder="formAnimalInfo.inputOrigemAimal.placeholder" v-model="paisOrigem" />
            </div>
            <div class="container-campo">
                <InputPadrao :label="formAnimalInfo.inputNascimentoAnimal.label"
                    :type="formAnimalInfo.inputNascimentoAnimal.type" :name="formAnimalInfo.inputNascimentoAnimal.nome"
                    :placeholder="formAnimalInfo.inputNascimentoAnimal.placeholder" v-model="dataNascimento" />
                <div class="campo">
                    <label for="descricao">Descrição</label>
                    <textarea name="descricao" placeholder="Coloque informações sobre o animal"
                        v-model="descricao"></textarea>
                </div>
            </div>
        </div>
        <button class="button" type="submit">{{ props.editarAnimalPreencherDados ? "Editar Animal" : formAnimalInfo.botaoAdicionar }}</button>
        <p :style="{ color: 'red' }" v-if="error">{{ error }}</p>
    </form>
</template>
<style>
form {
    padding: 2rem;
    background-color: #fff;
    width: 100%;
    display: flex;
    flex-direction: column;
    gap: 1rem;
    border-radius: 8px;
    height: fit-content;
}

.form-campos {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    column-gap: 1rem;
}

.container-campo {
    display: flex;
    flex-direction: column;
    gap: 1rem;
}

.campo {
    display: flex;
    flex-direction: column;
    gap: 0.5rem;
}

.campo label {
    font-size: 0.8rem;
}

.campo input,
.campo textarea {
    padding: 0.8rem;
    resize: none;
    border-radius: 8px;
    border: none;
    background-color: #f0f0f0;
    transition: 0.25s;
}

.campo input:focus,
.campo textarea:focus {
    outline: none;
    background-color: #c0c0c0;
}
</style>
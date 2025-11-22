<script setup>
import {ref, watch} from 'vue'
import InputPadrao from './form/InputPadrao.vue';
import ValidarCamposForm from '../util/ValidarCamposForm';

const props = defineProps({
    editarCuidadoPreencherCamposEditar: {
        type: Object
    }
})

const formCuidadoInfo = {
    titulo: "Criar Cuidado",
    botaoAdicionar: "Adicionar Cuidado",
    inputNomeCuidado: {
        nome: "nome",
        type: "text",
        placeholder: "Digite o nome do cuidado...",
        label: "Nome do Cuidado"
    }, 
    inputDuracaoCuidado: {
        nome: "duracao",
        type: "number",
        placeholder: "Digite a duração do cuidado...",
        label: "Duração do Cuidado"
    }, 
}

let nomeCuidado = ref('')
let duracaoCuidado = ref(null)
let descricaoCuidado = ref('')
let error = ref('')

function validarValoresRefCampoForm() {
    if(!ValidarCamposForm.validarTextoVazio(nomeCuidado.value)) {
        error.value = "Nome do cuidado deve ser fornecido"
        return false
    }
    if(!ValidarCamposForm.validarTextoVazio(descricaoCuidado.value)) {
        error.value = "Descrição do cuidado deve ser fornecida"
        return false
    }
    if(!ValidarCamposForm.validarDuracao(duracaoCuidado.value)) {
        error.value = "Duração não pode ser negativa"
        return false
    }
    return true
}

async function enviarForm() {
    if(!validarValoresRefCampoForm()) return false
    if(props.editarCuidadoPreencherCamposEditar) {
        const cuidadoSalvar = {
        nome: nomeCuidado.value,
        duracao: duracaoCuidado.value,
        descricao: descricaoCuidado.value,
    }
    try {
        const resposta = await fetch(`http://localhost:8080/api/cuidados/${props.editarCuidadoPreencherCamposEditar.id}`,{
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cuidadoSalvar)
        })
        if(resposta.ok) {
            nomeCuidado.value = ""
            duracaoCuidado.value = ""
            descricaoCuidado.value = ""
            error.value = ""
            alert("Cuidado editado com sucesso")
            window.location.reload()
        } else {
            error.value = "Houve um erro interno. Cuidado não editado"
            console.error("Erro interno, cuidado não editadoo")
        }
    } catch(err) {
        console.error("Impossivel editar cuidado")
    }
    } else {
        const cuidadoSalvar = {
        nome: nomeCuidado.value,
        duracao: duracaoCuidado.value,
        descricao: descricaoCuidado.value,
    }
    try {
        const resposta = await fetch("http://localhost:8080/api/cuidados", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cuidadoSalvar)
        })
        if(resposta.ok) {
            nomeCuidado.value = ""
            duracaoCuidado.value = ""
            descricaoCuidado.value = ""
            error.value = ""
            alert("Cuidado cadastrado com sucesso")
            window.location.reload()
            
        } else {
            error.value = "Houve algum erro interno. Cuidado não cadastrado"
            console.error(await resposta.text())
        }
    } catch (erro) {
        console.error("Erro de conexão: ", erro)
    }
    }
}
watch(() => props.editarCuidadoPreencherCamposEditar, (novoValor) => {
    if(novoValor) {
        console.log(novoValor)
        nomeCuidado.value = novoValor.nome
        duracaoCuidado.value = novoValor.duracao
        descricaoCuidado.value = novoValor.descricao
    } else {
        nomeCuidado.value = ""
        duracaoCuidado.value = ""
        descricaoCuidado.value = ""
    }
    
}, {immediate: true})
</script>
<template>
    <form @submit.prevent="enviarForm" action="">
        <h2>{{ props.editarCuidadoPreencherCamposEditar ? "Editar Cuidado" : formCuidadoInfo.titulo }}</h2>
        <div class="form-campos">
            <div class="container-campo">
                <InputPadrao 
                    :label="formCuidadoInfo.inputNomeCuidado.label" 
                    :type="formCuidadoInfo.inputNomeCuidado.type" 
                    :name="formCuidadoInfo.inputNomeCuidado.nome" 
                    :placeholder="formCuidadoInfo.inputNomeCuidado.placeholder"
                    v-model="nomeCuidado"
                />
                <InputPadrao 
                    :label="formCuidadoInfo.inputDuracaoCuidado.label" 
                    :type="formCuidadoInfo.inputDuracaoCuidado.type" 
                    :name="formCuidadoInfo.inputDuracaoCuidado.nome" 
                    :placeholder="formCuidadoInfo.inputDuracaoCuidado.placeholder"
                    v-model="duracaoCuidado"
                />
            </div>
            <div class="container-campo">
                <div class="campo">
                    <label for="descricao">Descrição</label>
                    <textarea v-model="descricaoCuidado" name="descricao" placeholder="Coloque informações sobre o cuidado"></textarea>
                </div>
            </div>
        </div>
        <button class="button" type="submit">{{ props.editarCuidadoPreencherCamposEditar ? "Editar Cuidado" : formCuidadoInfo.botaoAdicionar }}</button>
        <p :style="{color: 'red'}" v-if="error">{{ error }}</p>
    </form>
</template>

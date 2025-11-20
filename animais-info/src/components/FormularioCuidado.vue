<script setup>
import InputPadrao from './form/InputPadrao.vue';


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

</script>
<template>
    <form action="">
        <h2>{{ formCuidadoInfo.titulo }}</h2>
        <div class="form-campos">
            <div class="container-campo">
                <InputPadrao :label="formCuidadoInfo.inputNomeCuidado.label" 
                :type="formCuidadoInfo.inputNomeCuidado.type" 
                :name="formCuidadoInfo.inputNomeCuidado.nome" 
                :placeholder="formCuidadoInfo.inputNomeCuidado.placeholder"/>
                <InputPadrao :label="formCuidadoInfo.inputDuracaoCuidado.label" 
                :type="formCuidadoInfo.inputDuracaoCuidado.type" 
                :name="formCuidadoInfo.inputDuracaoCuidado.nome" 
                :placeholder="formCuidadoInfo.inputDuracaoCuidado.placeholder"/>
            </div>
            <div class="container-campo">
                <div class="campo">
                    <label for="descricao">Descrição</label>
                    <textarea name="descricao" placeholder="Coloque informações sobre o animal"></textarea>
                </div>
            </div>
        </div>
        <button class="button" type="submit">{{ formCuidadoInfo.botaoAdicionar }}</button>
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
    padding: 0.5rem;
}
</style>
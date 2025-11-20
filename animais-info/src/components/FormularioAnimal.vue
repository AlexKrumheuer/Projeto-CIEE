<script setup>
import { defineProps } from 'vue';
import InputPadrao from './form/InputPadrao.vue';

const props = defineProps({
    formInfo: {
        type: Object,
        required: true,
    },
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

</script>
<template>
    <form action="">
        <h2>{{ formAnimalInfo.titulo }}</h2>
        <div class="form-campos">
            <div class="container-campo">
                <InputPadrao :label="formAnimalInfo.inputNomeAnimal.label" 
                :type="formAnimalInfo.inputNomeAnimal.type" 
                :name="formAnimalInfo.inputNomeAnimal.nome" 
                :placeholder="formAnimalInfo.inputNomeAnimal.placeholder"/>
                <InputPadrao :label="formAnimalInfo.inputEspecieAnimal.label" 
                :type="formAnimalInfo.inputEspecieAnimal.type" 
                :name="formAnimalInfo.inputEspecieAnimal.nome" 
                :placeholder="formAnimalInfo.inputEspecieAnimal.placeholder"/>
            </div>
            <div class="container-campo">
                <InputPadrao :label="formAnimalInfo.inputHabitatAnimal.label" 
                :type="formAnimalInfo.inputHabitatAnimal.type" 
                :name="formAnimalInfo.inputHabitatAnimal.nome" 
                :placeholder="formAnimalInfo.inputHabitatAnimal.placeholder"/>
                <InputPadrao :label="formAnimalInfo.inputOrigemAimal.label" 
                :type="formAnimalInfo.inputOrigemAimal.type" 
                :name="formAnimalInfo.inputOrigemAimal.nome" 
                :placeholder="formAnimalInfo.inputOrigemAimal.placeholder"/>
            </div>
            <div class="container-campo">
                <InputPadrao :label="formAnimalInfo.inputNascimentoAnimal.label" 
                :type="formAnimalInfo.inputNascimentoAnimal.type" 
                :name="formAnimalInfo.inputNascimentoAnimal.nome" 
                :placeholder="formAnimalInfo.inputNascimentoAnimal.placeholder"/>
                <div class="campo">
                    <label for="descricao">Descrição</label>
                    <textarea name="descricao" placeholder="Coloque informações sobre o animal"></textarea>
                </div>
            </div>
        </div>
        <button class="button" type="submit">{{formAnimalInfo.botaoAdicionar}}</button>
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
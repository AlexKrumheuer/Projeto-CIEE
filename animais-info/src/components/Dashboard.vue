<script setup>
    import AnimaisRegistrados from './AnimaisRegistrados.vue';
    import FormularioCuidado from './FormularioCuidado.vue';
    import FormularioAnimal from './FormularioAnimal.vue';
    import {defineProps, ref, watch} from 'vue';
    import CuidadosRegistrados from './CuidadosRegistrados.vue';

    const props = defineProps({
        telaMostrar: String
    })

    const animalInfo = {
        titulo: "Animais Registrados",
        botaoAdicionar: "Adicionar Animal",
        tableHeader: {
            primeiraColuna: "Nome",
            segundaColuna: "Descrição",
            terceiraColuna: "Data de Nascimento",
            quartaColuna: "Espécie",
            quintaColuna: "Habitat",
            sextaColuna: "País de Origem",
            setimaColuna: "Ações",
        }
    }

    const cuidadosInfo = {
        titulo: "Cuidados Registrados",
        botaoAdicionar: "Adicionar Cuidado",
        tableHeader: {
            primeiraColuna: "Nome",
            segundaColuna: "Descrição",
            terceiraColuna: "Duração",
        }
    }
    
    watch(() => props.telaMostrar, () => {
        criar.value = false
    })

    
    let criar = ref(false);
    let editarCuidadoPreencherCamposEditar = ref(null)
    let editarAnimalPreencherCamposEditar = ref(null)
    const alterarValor = () => {
        if(criar.value && editarAnimalPreencherCamposEditar.value !== null) {
            editarAnimalPreencherCamposEditar.value = null
        }
        if(criar.value && editarCuidadoPreencherCamposEditar.value !== null){
            editarCuidadoPreencherCamposEditar.value = null
            return
        }
        editarAnimalPreencherCamposEditar.value = null
        editarCuidadoPreencherCamposEditar.value = null
        criar.value = !criar.value
    }

    const editarAnimaisEmit = (animal) => {
        if (criar.value && editarAnimalPreencherCamposEditar.value?.id === animal.id) {
            criar.value = false
            editarAnimalPreencherCamposEditar.value = null
            return
        }
        editarAnimalPreencherCamposEditar.value = animal
        criar.value = true
    }

    const editarCuidadoEmit = (cuidado) => {
        if (criar.value && editarCuidadoPreencherCamposEditar.value?.id === cuidado.id) {
            criar.value = false
            editarCuidadoPreencherCamposEditar.value = null
            return
        }
        editarCuidadoPreencherCamposEditar.value = cuidado
        criar.value = true
    }
</script>
<template>
    <section v-if="telaMostrar == 'animais'" class="dashboard">
        <AnimaisRegistrados 
            @editar-animais-emit="editarAnimaisEmit"
            :criar="criar" 
            @alterar-valor="alterarValor" 
            :componente-info="animalInfo"
        />
        <FormularioAnimal
            v-if="criar" 
            :editar-animal-preencher-dados="editarAnimalPreencherCamposEditar"
        />
    </section>
    <section v-else class="dashboard">
        <CuidadosRegistrados 
            @editar-cuidado-emit="editarCuidadoEmit" 
            :criar="criar" 
            @alterar-valor="alterarValor" 
            :componente-info="cuidadosInfo"
        />
        <FormularioCuidado 
            :editar-cuidado-preencher-campos-editar="editarCuidadoPreencherCamposEditar" 
            v-if="criar" 
        />
    </section>
</template>
<style>
    .dashboard {
        display: grid;
        width: 100%;
        height: auto;
        grid-template-rows: 60% 25%;
        gap: 2rem;
        padding: 2rem;
    }
</style>
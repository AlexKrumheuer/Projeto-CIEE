<script setup>
    import AnimaisRegistrados from './AnimaisRegistrados.vue';
    import FormularioCuidado from './FormularioCuidado.vue';
    import FormularioAnimal from './FormularioAnimal.vue';
    import {defineProps, ref} from 'vue';

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

    const animalCriar = {
        
    }

    const cuidadosInfo = {
        titulo: "Cuidados Registrados",
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

    const cuidadosCriar = {
        titulo: "Criar cuidado",
        botaoAdicionar: "Adicionar Cuidado",
        tableHeader: {
            primeiraColuna: "Nome do Cuidado",
            segundaColuna: "Descrição do cuidado",
            terceiraColuna: "Frequência do cuidado",
            quartaColuna: "categoria",
            quintaColuna: "duração em minutos",
            sextaColuna: null,
            setimaColuna: null,
        }
    }

    let criar = ref(false);

    const alterarValor = () => {
        console.log("teste")
        criar.value = !criar.value;
    }
</script>
<template>
    <section v-if="telaMostrar == 'animais'" class="dashboard">
        <AnimaisRegistrados :criar="criar" @alterar-valor="alterarValor" :componente-info="animalInfo"/>
        <FormularioAnimal v-if="criar" :form-info="animalCriar"/>
    </section>
    <section v-else class="dashboard">
        <AnimaisRegistrados :criar="criar" @alterar-valor="alterarValor" :componente-info="cuidadosInfo"/>
        <FormularioCuidado v-if="criar" :form-info="cuidadosCriar"/>
    </section>
</template>
<style>
    .dashboard {
        display: grid;
        width: 100%;
        height: auto;
        grid-template-rows: 45% 45%;
        gap: 2rem;
        padding: 2rem;
    }
</style>
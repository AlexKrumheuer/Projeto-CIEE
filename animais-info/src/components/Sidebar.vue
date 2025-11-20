<script setup>
import {defineProps, computed, defineEmits} from 'vue';
const props = defineProps({
    pagina: String
})

const emit = defineEmits('alterar-sidebar')

const alterarSidebar = (id) => {
    emit('alterar-sidebar', id)
}

const statusButtonBackground = computed(() => {
    if(props.pagina === "animais") {
        return '#1591EA'
    } else if(props.pagina === "cuidados") {
        return '#1591EA'
    }
    return ''
});
</script>
<template>
    <nav class="sidebar">
        <h4 class="title">
            <fa icon="paw"/>
            Animal Hub
        </h4>
        <div class="sidebar-interactive">
            <div v-on:click="() => alterarSidebar('animais')" :style="props.pagina==='animais' ? {backgroundColor: statusButtonBackground} : ''" class="sidebar-button">
                <fa icon="paw"/>
                <p>Animais</p>
            </div>
            <div v-on:click="() => alterarSidebar('cuidados')" :style="props.pagina==='cuidados' ? {backgroundColor: statusButtonBackground} : ''" class="sidebar-button">
                <fa icon="heart"/>
                <p>Cuidados</p>
            </div>
        </div>
    </nav>
</template>
<style>
    .sidebar {
        width: 100%;
        min-height: 100vh;
        background-color: #274358;
        padding: 1rem;
    }

    .title {
        margin-bottom: 10rem;
        padding: 1rem;
        color: #fff;
        font-size: 1.2rem;
    }

    .sidebar-interactive {
        display: flex;
        flex-direction: column;
        gap: 2rem;
    }

    .sidebar-button {
        display: flex;
        cursor: pointer;
        align-items: center;
        font-size: 1.2rem;
        color: #fff;
        gap: 0.7rem;
        padding: 1rem;
        border-radius: 8px;
        transition: 0.25s;
    }

    .sidebar-button:hover {
        background-color: #1591EA;
    }
</style>
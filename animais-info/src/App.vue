<script setup>
  import Sidebar from './components/Sidebar.vue';
  import Dashboard from './components/Dashboard.vue';
  import {ref} from 'vue';


  let tela = true // true para animais, false para cuidados
  let telaMostrar = ref("animais")

  const alterarSidebar = (id) => {
    if(id === telaMostrar.value) return
    if(id === 'animais') {
      telaMostrar.value = 'animais'
    } else {
      telaMostrar.value = 'cuidados'
    }
  }
</script>

<template> 
  <Sidebar @alterar-sidebar="alterarSidebar" :pagina="telaMostrar"/>
  <Dashboard v-if="tela" :telaMostrar="telaMostrar"/>
  <Dashboard v-else :telaMostrar="telaMostrar"/>
</template>

<style>
</style>

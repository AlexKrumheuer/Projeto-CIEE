<script setup>
const props = defineProps({
    label: String,
    type: String,
    name: String,
    placeholder: String,
})
</script>
<template>
    <div class="campo">
        <label :for="props.name">{{ props.label }}</label>
        <input :type="props.type" :name="props.name" :placeholder="props.placeholder">
    </div>
</template>
<style>
.campo {
    display: flex;
    flex-direction: column;
    gap: 0.5rem;
}

.campo label {
    font-size: 0.8rem;
}

.campo input {
    padding: 0.5rem;
}
</style>
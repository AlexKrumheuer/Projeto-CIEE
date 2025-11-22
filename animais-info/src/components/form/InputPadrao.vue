<script setup>
import {defineEmits} from 'vue'
const props = defineProps({
    modelValue: [Number, String],
    label: String,
    type: String,
    name: String,
    placeholder: String,
})

const emit = defineEmits(['update:modelValue'])

</script>
<template>
    <div class="campo">
        <label :for="props.name">{{ props.label }}</label>
        <input 
            :value="props.modelValue"
            @input="$emit('update:modelValue', $event.target.value)" 
            :type="props.type" 
            :name="props.name" 
            :placeholder="props.placeholder"
        >
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
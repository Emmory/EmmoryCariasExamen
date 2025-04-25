<template>
    <div>
      <h1>Crear Chequera</h1>
      <div>
        <label>ID de Cuenta:</label>
        <input v-model="chequera.cuentaId" type="number" />
      </div>
      <div>
        <label>Número Inicial:</label>
        <input v-model="chequera.numeroInicial" type="number" />
      </div>
      <div>
        <label>Número Final:</label>
        <input v-model="chequera.numeroFinal" type="number" />
      </div>
      <button @click="guardarChequera">Guardar Chequera</button>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import { useRouter } from 'vue-router'
  import { crearChequera } from '../services/ChequeraService'
  
  const router = useRouter()
  
  const chequera = ref({
    cuentaId: null,
    numeroInicial: null,
    numeroFinal: null
  })
  
  const guardarChequera = async () => {
    try {
      await crearChequera({
  cuentaId: chequera.value.cuentaId,
  numeroInicial: chequera.value.numeroInicial,
  numeroFinal: chequera.value.numeroFinal
})
      router.push('/chequeras')
    } catch (error) {
      alert('Error al crear la chequera')
      console.error(error)
    }
  }
  </script>
  
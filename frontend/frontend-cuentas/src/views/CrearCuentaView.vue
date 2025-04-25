<template>
    <div>
      <h1>Crear cuenta</h1>
      <form @submit.prevent="guardarCuenta">
        <div>
          <label>ID de cliente:</label>
          <input v-model="cuenta.cliente.id" type="number" required />
        </div>
        <div>
          <label>Tipo:</label>
          <select v-model="cuenta.tipo" required>
            <option value="monetaria">Monetaria</option>
            <option value="ahorro">Ahorro</option>
          </select>
        </div>
        <div>
          <label>Monto de apertura:</label>
          <input v-model="cuenta.montoApertura" type="number" required />
        </div>
        <div>
          <label>Motivo de estado (opcional):</label>
          <input v-model="cuenta.motivoEstado" />
        </div>
        <button type="submit">Guardar cuenta</button>
      </form>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import { useRouter } from 'vue-router'
  import { crearCuenta } from '../services/CuentaService'
  
  const router = useRouter()
  
  const cuenta = ref({
  cliente: { id: '' }, // en vez de clienteId
  tipo: '',
  montoApertura: '',
  estado: 'activa',
  motivoEstado: ''
})
  
const guardarCuenta = async () => {
  try {
    await crearCuenta(cuenta.value)
    alert('Cuenta creada correctamente')
    router.push('/cuentas')
  } catch (error) {
    console.error(error)
    alert('Error al crear la cuenta')
  }
}
  </script>
  
  
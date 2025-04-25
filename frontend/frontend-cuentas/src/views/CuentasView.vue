<template>
  <div>
    <h1>Listado de Cuentas</h1>
    <router-link to="/cuentas/crear">
      <button>Crear Cuenta</button>
    </router-link>

    <ul>
      <li v-for="cuenta in cuentas" :key="cuenta.id">
        <strong>Cuenta #{{ cuenta.id }}</strong><br />
        Cliente: {{ cuenta.cliente?.nombre || 'ID: ' + cuenta.cliente?.id }}<br />
        Tipo: {{ cuenta.tipo }}<br />
        Monto: Q{{ cuenta.montoApertura }}<br />
        Estado actual: <strong>{{ cuenta.estado }}</strong><br />
        Motivo: {{ cuenta.motivoEstado || 'Sin motivo registrado' }}<br />

        <!-- Botón para abrir el formulario -->
        <button @click="mostrarFormulario(cuenta.id)">Cambiar estado</button>

        <!-- Formulario de cambio de estado -->
        <div v-if="cuentaMostrando === cuenta.id">
          <select v-model="nuevoEstado.estado" required>
            <option value="activa">Activa</option>
            <option value="bloqueada">Bloqueada</option>
            <option value="cerrada">Cerrada</option>
          </select>
          <input v-model="nuevoEstado.motivoEstado" placeholder="Motivo del cambio" required />
          <button @click="guardarEstado(cuenta.id)">Guardar</button>
        </div>

        <hr />
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { listarCuentas, actualizarEstadoCuenta } from '../services/CuentaService'

const cuentas = ref([])
const cuentaMostrando = ref(null)
const nuevoEstado = ref({ estado: '', motivoEstado: '' })

onMounted(async () => {
  cuentas.value = await listarCuentas()
})

const mostrarFormulario = (cuentaId) => {
  cuentaMostrando.value = cuentaId
  nuevoEstado.value = { estado: '', motivoEstado: '' }
}

const guardarEstado = async (cuentaId) => {
  try {
    await actualizarEstadoCuenta(cuentaId, nuevoEstado.value.estado, nuevoEstado.value.motivoEstado)
    alert('Estado actualizado correctamente')
    cuentas.value = await listarCuentas()
    cuentaMostrando.value = null
  } catch (error) {
    alert('Error al actualizar estado')
    console.error(error)
  }
}
</script>

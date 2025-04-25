<template>
  <div>
    <h1>Editar Cliente</h1>

    <div v-if="cliente">
      <div>
        <label>Nombre:</label>
        <input v-model="cliente.nombre" />
      </div>
      <div>
        <label>Apellido:</label>
        <input v-model="cliente.apellido" />
      </div>
      <div>
        <label>Identificación:</label>
        <input v-model="cliente.identificacion" />
      </div>
      <div>
        <label>Nacimiento:</label>
        <input type="date" v-model="cliente.fechaNacimiento" />
      </div>
      <div>
        <label>Dirección:</label>
        <input v-model="cliente.direccion" />
      </div>
      <div>
        <label>Correo:</label>
        <input v-model="cliente.correo" />
      </div>
      <div>
        <label>Teléfono:</label>
        <input v-model="cliente.telefono" />
      </div>

      <button @click="guardarCambios">Guardar Cambios</button>
    </div>

    <div v-else>
      Cargando cliente...
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import ClienteService from '../services/ClienteService'

const route = useRoute()
const router = useRouter()
const cliente = ref(null)

onMounted(async () => {
  try {
    const id = route.params.id
    const datos = await ClienteService.obtenerPorId(id)
    cliente.value = datos
  } catch (error) {
    alert('No se pudo cargar el cliente')
    console.error(error)
  }
})

async function guardarCambios() {
  try {
    await ClienteService.actualizar(route.params.id, cliente.value)
    alert('Cliente actualizado correctamente')
    router.push('/clientes')
  } catch (error) {
    alert('Error al actualizar el cliente')
    console.error(error)
  }
}
</script>







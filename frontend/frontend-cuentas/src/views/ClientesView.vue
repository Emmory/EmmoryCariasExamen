<template>
  <div>
    <h1>Listado de Clientes</h1>
    <button @click="irACrear" style="margin-bottom: 20px;">Nuevo Cliente</button>
    <ul>
      <li v-for="cliente in clientes" :key="cliente.id">
        <strong>{{ cliente.nombre }} {{ cliente.apellido }}</strong><br />
        ID: {{ cliente.identificacion }}<br />
        Nacimiento: {{ cliente.fechaNacimiento }}<br />
        Dirección: {{ cliente.direccion }}<br />
        Correo: {{ cliente.correo }}<br />
        Teléfono: {{ cliente.telefono }}<br /><br />
        <button @click="eliminarCliente(cliente.id)">🗑 Eliminar</button>
        <button @click="irAEditar(cliente.id)">✏️ Editar</button>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import { useRouter } from 'vue-router'
import { listarClientes, eliminarClientePorId } from '../services/ClienteService'


const clientes = ref([])
const router = useRouter()

onMounted(async () => {
  clientes.value = await listarClientes()
})

async function eliminarCliente(id) {
  const confirmar = confirm('¿Estás seguro de eliminar este cliente?')
  if (!confirmar) return

  try {
    await eliminarClientePorId(id)
    clientes.value = clientes.value.filter(c => c.id !== id)
    alert('Cliente eliminado correctamente')
  } catch (error) {
    alert('Error al eliminar el cliente: ' + error.message)
  }
}
function irACrear() {
  router.push('/clientes/crear')
}

function irAEditar(id) {
  router.push(`/clientes/editar/${id}`);
}


</script>



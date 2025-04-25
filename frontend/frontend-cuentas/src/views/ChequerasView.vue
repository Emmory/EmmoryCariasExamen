<template>
  <div>
    <h1>Listado de Chequeras</h1>
    <button @click="router.push('/chequeras/crear')">Nueva Chequera</button>
    <ul>
      <li v-for="chequera in chequeras" :key="chequera.id">
        <strong>Chequera #{{ chequera.id }}</strong><br>
        Cuenta ID: {{ chequera.cuenta?.id }}<br>
        Número Inicial: {{ chequera.numeroInicial }}<br>
        Número Final: {{ chequera.numeroFinal }}<br>
        <router-link :to="`/chequeras/${chequera.id}/cheques`">
          Ver Cheques
        </router-link>
        <br>
        <button @click="mostrarFormulario(chequera.id)">Cambiar estado</button>

        <button @click="verCheques(chequera.id)">Ver Cheques</button>


        <div v-if="chequeraMostrando === chequera.id">
          <select v-model="nuevoEstado.estado" required>
            <option value="activa">Activa</option>
            <option value="bloqueada">Bloqueada</option>
            <option value="cancelada">Cancelada</option>
          </select>
          <input v-model="nuevoEstado.motivoEstado" placeholder="Motivo del cambio" required />
          <button @click="guardarEstado(chequera.id)">Guardar</button>
        </div>

      </li>
    </ul>
  </div>
</template>
  
  <script setup>
  import { ref, onMounted } from 'vue'
  import { useRouter } from 'vue-router'
  import { listarChequeras } from '../services/ChequeraService'
  
  
  const chequeras = ref([])
  const router = useRouter()
  const chequeraMostrando = ref(null)
  const nuevoEstado = ref({ estado: '', motivoEstado: '' })


  
  onMounted(async () => {
    try {
      chequeras.value = await listarChequeras()
    } catch (e) {
      console.error('Error al cargar chequeras:', e)
    }
  })

  const mostrarFormulario = (id) => {
  chequeraMostrando.value = id
  nuevoEstado.value = { estado: '', motivoEstado: '' }
}

const guardarEstado = async (id) => {
  try {
    await actualizarEstadoChequera(id, nuevoEstado.value.estado, nuevoEstado.value.motivoEstado)
    alert('Estado actualizado')
    chequeras.value = await listarChequeras()
    chequeraMostrando.value = null
  } catch (error) {
    alert('Error al guardar estado')
    console.error(error)
  }
}

const verCheques = (chequeraId) => {
  router.push(`/chequeras/${chequeraId}/cheques`)
}

  </script>
  
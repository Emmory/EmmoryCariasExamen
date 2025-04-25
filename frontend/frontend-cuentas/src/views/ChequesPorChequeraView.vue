<template>
  <div>
    <h1>Cheques de la Chequera #{{ chequeraId }}</h1>

    <ul v-if="cheques.length > 0">
      <li v-for="cheque in cheques" :key="cheque.id">
        <strong>Cheque #{{ cheque.numero }}</strong> - Estado: {{ cheque.estado }}
        <br />
        Motivo: {{ cheque.motivoEstado || 'Ninguno' }}
      </li>
    </ul>

    <p v-else>No hay cheques registrados para esta chequera.</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import { obtenerChequesPorChequera } from '../services/ChequeService'

const route = useRoute()
const chequeraId = ref(route.params.id)
const cheques = ref([])

onMounted(async () => {
  try {
    const data = await obtenerChequesPorChequera(chequeraId.value)
    cheques.value = data
  } catch (error) {
    console.error('Error al obtener cheques:', error)
  }
})
</script>

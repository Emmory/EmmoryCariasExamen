<template>
    <div>
      <h1>Crear Cliente</h1>
      <form @submit.prevent="guardarCliente">
        <div><label>Nombre:</label><input v-model="cliente.nombre" required /></div>
        <div><label>Apellido:</label><input v-model="cliente.apellido" required /></div>
        <div><label>Identificación:</label><input v-model="cliente.identificacion" required /></div>
        <div><label>Nacimiento:</label><input type="date" v-model="cliente.fechaNacimiento" required /></div>
        <div><label>Dirección:</label><input v-model="cliente.direccion" required /></div>
        <div><label>Correo:</label><input type="email" v-model="cliente.correo" required /></div>
        <div><label>Teléfono:</label><input v-model="cliente.telefono" required /></div>
        <button type="submit">Guardar</button>
      </form>
    </div>
  </template>
  
  <script setup>
  import { reactive } from 'vue'
  import { useRouter } from 'vue-router'
  import { crearCliente } from '../services/ClienteService'

  
  const router = useRouter()
  
  const cliente = reactive({
    nombre: '',
    apellido: '',
    identificacion: '',
    fechaNacimiento: '',
    direccion: '',
    correo: '',
    telefono: ''
  })
  
  async function guardarCliente() {
    try {
      await crearCliente(cliente)
      alert('Cliente creado correctamente')
      router.push('/') // vuelve al listado
    } catch (error) {
      alert('Error al crear cliente: ' + error.message)
    }
  }
  </script>
  
  <style scoped>
  form {
    display: flex;
    flex-direction: column;
    gap: 0.5rem;
    max-width: 400px;
  }
  input {
    padding: 0.5rem;
  }
  button {
    background: #2563eb;
    color: white;
    padding: 0.5rem;
    border: none;
    border-radius: 4px;
  }
  </style>
  
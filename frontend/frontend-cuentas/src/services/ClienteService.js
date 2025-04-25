// src/services/ClienteService.js
const API_URL = 'http://localhost:8081/api/clientes';

export async function listarClientes() {
  const res = await fetch(API_URL);
  return res.json();
}

export async function crearCliente(cliente) {
  const res = await fetch(API_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(cliente)
  });
  return res.json();
}

export async function eliminarClientePorId(id) {
  const response = await fetch(`http://localhost:8081/api/clientes/${id}`, {
    method: 'DELETE'
  })
  if (!response.ok) throw new Error('No se pudo eliminar el cliente')
}



async function actualizar(id, cliente) {
  const res = await fetch(`http://localhost:8081/api/clientes/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(cliente)
  });
  return await res.json();
}


export default {
  async obtenerPorId(id) {
    const res = await fetch(`${API_URL}/${id}`)
    if (!res.ok) throw new Error('No se pudo obtener el cliente')
    return await res.json()
  },
  actualizar
}

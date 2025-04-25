const API_URL = 'http://localhost:8081/api/chequeras'

export async function listarChequeras() {
  const res = await fetch(API_URL)
  if (!res.ok) throw new Error('Error al listar chequeras')
  return res.json()
}

export async function crearChequera(chequera) {
    const res = await fetch(API_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(chequera)
    })
    if (!res.ok) throw new Error('Error al crear la chequera')
    return res.json()
  }

  export async function actualizarEstadoChequera(id, estado, motivoEstado) {
    const res = await fetch(`http://localhost:8081/api/chequeras/${id}/estado`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ estado, motivoEstado })
    })
    if (!res.ok) throw new Error('No se pudo actualizar el estado')
    return res.json()
  }
  
  
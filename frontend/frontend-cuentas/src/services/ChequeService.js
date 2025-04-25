const API_URL = 'http://localhost:8081/api/cheques'


export async function obtenerChequesPorChequera(idChequera) {
  const res = await fetch(`${API_URL}/por-chequera/${idChequera}`);
  if (!res.ok) {
    throw new Error('Error al obtener los cheques');
  }
  return res.json();
}



export async function actualizarEstadoCheque(id, estado, motivoEstado) {
    const res = await fetch(`http://localhost:8081/api/cheques/${id}/estado`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ estado, motivoEstado })
    })
    if (!res.ok) throw new Error('No se pudo actualizar el estado del cheque')
    return res.json()
  }
  
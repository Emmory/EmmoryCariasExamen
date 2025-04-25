const API_URL = 'http://localhost:8081/api/cuentas'

export async function listarCuentas() {
  const res = await fetch(API_URL)
  return res.json()
}

// Ya tienes esto:
// export async function crearCuenta(cuenta) { ... }


export async function crearCuenta(cuenta) {
  const res = await fetch(API_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(cuenta)
  })

  if (!res.ok) throw new Error('Error al crear la cuenta')
  return res.json()
}

export async function actualizarEstadoCuenta(id, estado, motivoEstado) {
  const res = await fetch(`http://localhost:8081/api/cuentas/${id}/estado`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ estado, motivoEstado })
  })
  if (!res.ok) throw new Error('No se pudo actualizar el estado')
  return res.json()
}



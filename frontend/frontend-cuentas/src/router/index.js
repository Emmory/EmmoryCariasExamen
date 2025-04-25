import { createRouter, createWebHistory } from 'vue-router'
import ClientesView from '../views/ClientesView.vue'
import EditarClienteView from '../views/EditarClienteView.vue'
import CrearClienteView from '../views/CrearClienteView.vue'
import CrearCuentaView from '../views/CrearCuentaView.vue'
import CuentasView from '../views/CuentasView.vue'
import CrearChequeraView from '../views/CrearChequeraView.vue'
import ChequerasView from '../views/ChequerasView.vue'
import ChequesPorChequeraView from '../views/ChequesPorChequeraView.vue'

const routes = [
  {
    path: '/',
    name: 'clientes',
    component: ClientesView
  },
  {
    path: '/clientes',
    name: 'clientesPath',
    component: ClientesView
  },
  {
    path: '/clientes/crear',
    name: 'CrearCliente',
    component: CrearClienteView
  },
  {
    path: '/clientes/editar/:id',
    name: 'EditarCliente',
    component: EditarClienteView,
    props: true
  },
  {
    path: '/cuentas',
    name: 'CuentasView',
    component: CuentasView
  },
  {
    path: '/cuentas/crear',
    name: 'CrearCuenta',
    component: CrearCuentaView
  },
  {
    path: '/chequeras',
    name: 'ChequerasView',
    component: ChequerasView
  },
  {
    path: '/chequeras/crear',
    name: 'CrearChequera',
    component: CrearChequeraView
  },
  {
    path: '/cheques/por-chequera/:chequeraId',
    name: 'ChequesPorChequera',
    component: ChequesPorChequeraView,
    props: true
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router

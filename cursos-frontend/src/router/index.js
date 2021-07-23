import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "@/components/template/Home"
import Carrinho from "@/components/carrinho/Carrinho"
import Cursos from "@/components/admin/cursos/Cursos"
import Auth from "@/components/auth/Authentication"

Vue.use(VueRouter)

const routes = [
  {
    path: "/", 
    component: Home,
    name: "Home"
  },
  {
    path: "/carrinho", 
    component: Carrinho,
    name: "Carrinho"
  },
  {
    path: "/admin/cursos", 
    component: Cursos,
    name: "AdminCursos"
  },
  {
    path: "/auth", 
    component: Auth,
    name: "Auth"
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

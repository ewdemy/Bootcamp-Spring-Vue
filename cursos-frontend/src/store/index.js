import Vue from 'vue'
import Vuex from 'vuex'
import { getCursos } from "@/service/cursos"

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    cursos: [],
    carrinho: []
  },
  mutations: {
      setCursos(state, cursos){
        state.cursos = cursos
      },
      adicionaCursoAoCarrinho(state, { id }){
        state.carrinho.push({id, quantidade: 1})
      },
      incrementaCurso(state, {id}){
        const cursoCar = state.carrinho.find(item => item.id == id)
        cursoCar.quantidade++
      } 
  },
  actions: {
    carregaCursos({ commit }){

      getCursos().then(response => {
        console.log(response.data)
        commit("setCursos", response.data)
      }).catch(err =>{
        console.log(err)
      })
    },
    adicionarAoCarrinho({ state, commit }, curso){

      const cursoCar = state.carrinho.find(item => item.id === curso.id)

      if(cursoCar){
        commit("incrementaCurso", cursoCar)
      }else {
        commit("adicionaCursoAoCarrinho", curso)
      }
    }
  },
  getters: {
    cursosAVenda(state) {
      return state.cursos.map((curso) => {
        return {
          ...curso
        }
      } )
    },
    cursosCarrinho(state){
      return state.carrinho.map(({id, quantidade}) => {
        const curso = state.cursos.find(item => item.id === id)
        return {
          ...curso,
          quantidade
        }
      })
    }
  },
  modules: {
  }
})

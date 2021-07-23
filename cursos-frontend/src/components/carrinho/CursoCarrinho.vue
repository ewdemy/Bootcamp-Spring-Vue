<template>
    <v-row align="center">
      <v-col cols="12" md="1" >
        <img :src="curso.imagemURL" width="80px">
      </v-col>
      <v-col cols="12" md="6" >
        <h3>{{curso.nome}}</h3>
        <h5>{{curso.preco}}</h5>
      </v-col>
      <v-col cols="12" md="1" >
        <v-text-field label="quantidade" type="number" v-model="curso.quantidade" min="1" />
      </v-col>
      <v-col cols="12" md="3" >
        <div class="d-flex justify-end">
          <small>subtotal: {{subtotal}}</small>
        </div>
      </v-col>
      <v-col cols="12" md="1" >
        <v-btn icon class="error">
          <v-icon color="white">mdi-delete</v-icon>
        </v-btn>
      </v-col>
    </v-row>
</template>

<script>
export default {
    name: "CursoCarrinho",
    data(){
      return {

      }
    },
    props: [
      "curso"
    ],
    computed: {
      subtotal(){
        return this.curso.quantidade * this.curso.preco
      }
    }

}
</script>

<style>

</style>
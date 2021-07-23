<template>
  <v-card
    class="mx-auto"
    max-width="344"
  >
    <v-img
      :src="curso.img"
      height="200px"
    ></v-img>

    <v-card-title>
      {{curso.nome}}
    </v-card-title>

    <v-card-subtitle>
      {{curso.preco}}
    </v-card-subtitle>

    <v-card-actions>
      <v-btn
        color="success"
        block
        @click="adicionarCarrinho"
      >
        Adicionar ao carrinho
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
    name: "CursoItem",
    props: [
      "curso"
    ],
    methods: {
      adicionarCarrinho(){
        this.$store.dispatch("adicionarAoCarrinho", this.curso)
      }
    }

}
</script>

<style>

</style>
<template>
  <v-app>

    <Header />
  

    <v-main>
      <v-container fluid>
        <router-view></router-view>
      </v-container>
    </v-main>
    <Footer />
  </v-app>
</template>

<script>
import Header from "@/components/template/Header"
import Footer from "@/components/template/Footer"

export default {
  components: {
    Header,
    Footer,
   },
  name: 'App',

  data: () => ({
    //
  }),
  created() {
     this.$store.dispatch("carregaCursos")
  }
};
</script>

<template>
    <v-row>
        <v-col cols="12" lg="3" md="4" sm="6" xs="12" v-for="(c, index) in cursos" :key="index">
            <CursoItem :curso="c" />
       
        </v-col>
    </v-row>
</template>

<script>
import CursoItem from "@/components/cursos/CursoItem"
export default {
    name: "Home",
    components:{
        CursoItem,
    },
    data(){
        return {
            
        }
    },
    computed: {
        cursos(){
            return this.$store.getters.cursosAVenda
        }
    },


}
</script>

<style>

</style>
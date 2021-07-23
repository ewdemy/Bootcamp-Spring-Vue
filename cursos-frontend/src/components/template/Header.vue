<template>
    <div>
        <v-app-bar
        color="deep-purple accent-4"
        dense
        dark
        >

        <v-toolbar-title>
            <router-link :to="{name: 'Home'}" tag="div" class="link">
                CURSOSONLINE
            </router-link>
        </v-toolbar-title>

        <v-spacer></v-spacer>

        <v-btn :to="{name: 'Carrinho'}" icon>
            <v-icon>mdi-cart</v-icon>
        </v-btn>

        <v-menu
            left
            bottom
        >
            <template v-slot:activator="{ on, attrs }">
            <v-btn
                icon
                v-bind="attrs"
                v-on="on"
            >
                <v-icon>mdi-cog</v-icon>
            </v-btn>
            </template>

            <v-list>
            <v-list-item :to="{name: 'AdminCursos'}">
                <v-list-item-title>Cursos</v-list-item-title>
            </v-list-item>
            </v-list>
        </v-menu>

        <v-menu
            left
            bottom
        >
            <template v-slot:activator="{ on, attrs }">
            <v-btn
                icon
                v-bind="attrs"
                v-on="on"
            >
                <v-icon>mdi-account</v-icon>
            </v-btn>
            </template>

            <v-list>
            <v-list-item :to="{name: 'Auth'}">
                <v-list-item-title>Login</v-list-item-title>
            </v-list-item>
            <v-list-item>
                <v-list-item-title>Logout</v-list-item-title>
            </v-list-item>
            </v-list>
        </v-menu>
        </v-app-bar>
    </div>
</template>

<script>
export default {
    name: "Header",
};
</script>

<style scoped>
.link{
    cursor: pointer;
}
</style>
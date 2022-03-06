<template>
<!--  <v-app id="inspire">-->
<!--    <v-navigation-drawer-->
<!--        v-model="drawer"-->
<!--        app-->
<!--    >-->
<!--      <AppHeader></AppHeader>-->
<!--    </v-navigation-drawer>-->

<!--    <v-app-bar app>-->
<!--      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>-->

<!--      <v-toolbar-title>Application</v-toolbar-title>-->
<!--    </v-app-bar>-->

<!--    <v-main>-->
<!--      &lt;!&ndash;  &ndash;&gt;-->
<!--      <router-view/>-->
<!--    </v-main>-->
<!--  </v-app>-->
  <v-app>
    <router-view/>
  </v-app>

</template>

<script>
export default {
}
</script>
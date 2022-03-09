<!--<template>-->
<!--  <div>-->
<!--  <h1>main page</h1>-->
<!--  <div>{{data}}</div>-->
<!--  <button v-on:click="getInfo">정보 받아오기</button>-->
<!--  </div>-->
<!--</template>-->
<template>
  <v-app id="inspire">
    <v-navigation-drawer
        v-model="drawer"
        app
    >
      <AppHeader></AppHeader>
    </v-navigation-drawer>

    <v-app-bar app>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Application</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <ItemList :key="componentKey"></ItemList>
<!--      <router-view/>-->
    </v-main>
  </v-app>
</template>

<script>
import AppHeader from "@/components/AppHeader";
import ItemList from "@/components/ItemList";
export default {
  name: "MainPage",
  data : function ()
  {
    return {
      componentKey: 0
    }
  },
  mounted() {
    this.componentKey +=1;
  }
  ,
  components : {
    ItemList,
    AppHeader

  },



}
</script>


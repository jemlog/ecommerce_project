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
      <Profile v-bind:userInfo="this.$store.state.userId"></Profile>
    </v-navigation-drawer>

    <v-app-bar app>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Application</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <ItemList :key="componentKey"></ItemList>
<!--      <router-view/>-->
      <router-link to="/orderList"><v-btn color="success">주문목록</v-btn></router-link>
    </v-main>
  </v-app>
</template>

<script>
import AppHeader from "@/components/AppHeader";
import ItemList from "@/components/ItemList";
import Profile from "@/components/Profile";
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
    Profile,
    ItemList,
    AppHeader

  },



}
</script>


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
      <!--  -->
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
import {fetchPosts} from "@/api/posts";
import AppHeader from "@/components/AppHeader";
export default {
  name: "MainPage",
  data : function ()
  {
    return {
      data : '',
      drawer: null
    }
  },
  components : {
    AppHeader
  },
  methods : {
   async getInfo(){
      const {data} = await fetchPosts()
      this.data = data;
    }
  }


}
</script>


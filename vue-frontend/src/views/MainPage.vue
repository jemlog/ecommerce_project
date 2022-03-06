<template>
  <div>
  <h1>main page</h1>
  <div>{{data}}</div>
  <button v-on:click="getInfo">정보 받아오기</button>
  </div>
</template>

<script>
import {fetchPosts} from "@/api/posts";
export default {
  name: "MainPage",
  data : function ()
  {
    return {
      data : ''
    }
  },
  methods : {
   async getInfo(){
      const {data} = await fetchPosts()
      this.data = data;
    }
  }


}
</script>


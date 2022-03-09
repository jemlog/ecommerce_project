<template>
  <div>
    <ul>
      <li v-for="item in items" v-bind:key="item">
        {{item}}
      </li>
    </ul>
    <router-link to="/addItems"><v-btn color="success">제품 추가</v-btn></router-link>
  </div>

</template>

<script>


import {fetchPosts} from "@/api/posts";

export default {
  name: "ItemList",
  created() {
    this.fetchData()
  },
  data : function ()
  {
     return {
       items : [],
       componentKey:0
     }
  },
  methods : {
    async fetchData()
    {
      const {data} = await fetchPosts()
      this.items = data;
    }
  },


}
</script>

<style scoped>

</style>
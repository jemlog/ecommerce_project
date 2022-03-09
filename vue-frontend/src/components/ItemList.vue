<template>
  <div>
    <ul>
      <li v-for="item in items" v-bind:key="item">
        <Item v-bind:itemprop="item" v-on:delete="deleteItem"></Item>
      </li>
    </ul>
    <router-link to="/addItems"><v-btn color="success">제품 추가</v-btn></router-link>
  </div>

</template>

<script>


import {deletePosts, fetchPosts} from "@/api/posts";
import Item from "@/components/Item";

export default {
  name: "ItemList",
  components: {Item},
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
    },
   async deleteItem(itemId)
    {
      await deletePosts(itemId);
      this.$router.go(this.$router.currentRoute);
    }
  },


}
</script>

<style scoped>

</style>
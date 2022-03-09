
<template>
  <v-form v-on:submit="submitForm">

    <v-text-field
        v-model="itemName"
        label="ItemName"
        required
    ></v-text-field>
    <v-text-field
        v-model="quantity"
        label="Quantity"
        required
    ></v-text-field>
    <v-text-field
        v-model="price"
        label="Price"
        required
    ></v-text-field>
    <v-btn
        color="success"
        class="mr-4"
        type="submit"
    >
      Item 등록
    </v-btn>

  </v-form>
</template>
<script>




import {createPosts} from "@/api/posts";

export default {

  name: "AddItemForm",
  data : function (){
    return {
      itemName : '',
      quantity : '',
      price : ''
    }
  },
  methods : {
    async submitForm(event){
      event.preventDefault();
      const itemData = {
        itemName : this.itemName,
        quantity : this.quantity,
        price : this.price
      }
     // const {data} = await loginUser(userData);
     // this.$store.commit('setToken',data.token);
     // this.$store.commit('setUsername',data.user.username);
     // saveAuthToCookie(data.token);
     // saveUserToCookie(data.user.username);
      createPosts(itemData)
      this.initForm();
      //await this.$store.dispatch('GETDATA');
      this.$router.push("/main");
    },
    initForm(){
      this.itemName = '';
      this.quantity = '';
      this.price = '';
    }
  }
}
</script>

<style>

</style>


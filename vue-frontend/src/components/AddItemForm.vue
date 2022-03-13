
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
    <v-file-input v-model="imgfile"
    label="imgfile">
    </v-file-input>
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
      price : '',
      imgfile : ''
    }
  },
  methods : {
    async submitForm(event){
      event.preventDefault();
      let formData = new FormData();
      formData.append("itemName",this.itemName)
      formData.append("quantity",this.quantity)
      formData.append("price",this.price)
      formData.append("imgfile",this.imgfile)
      // const itemData = {
      //   itemName : this.itemName,
      //   quantity : this.quantity,
      //   price : this.price,
      //   imgFile : this.imgFile
      // }
     // const {data} = await loginUser(userData);
     // this.$store.commit('setToken',data.token);
     // this.$store.commit('setUsername',data.user.username);
     // saveAuthToCookie(data.token);
     // saveUserToCookie(data.user.username);
      console.log(formData.get("imgfile"))
      createPosts(formData)
      this.initForm();
      //await this.$store.dispatch('GETDATA');
      this.$router.push("/main");
    },
    initForm(){
      this.itemName = '';
      this.quantity = '';
      this.price = '';
      this.imgfile = null;
    }
  }
}
</script>

<style>

</style>


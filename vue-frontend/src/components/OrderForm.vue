<template>
  <v-form v-on:submit="submitForm">
    <v-text-field
        v-model="orderQuantity"
        label="OrderQuantity"
        required
    ></v-text-field>
    <v-btn
        color="success"
        class="mr-4"
        type="submit"
    >
      제출
    </v-btn>

  </v-form>
</template>

<script>
import {createOrders} from "@/api/order";

export default {
  name: "OrderForm",
  data : function ()
  {
    return {
      orderQuantity : ''
    }
  },

  // TODO : 주문시 사용자 ID, 상품 ID 두개가 있어야함,
  methods : {
    submitForm(event)
    {
      event.preventDefault();
      console.log('폼 제출');
      const orderData = {
        orderQuantity : this.orderQuantity,
        userId : this.$store.state.userId,
        itemId : this.$route.query.itemId
      }
      createOrders(orderData)
      this.initForm();
      this.$router.push('/main');
    },
    initForm(){
      this.orderQuantity = ''
    }

  }
}
</script>


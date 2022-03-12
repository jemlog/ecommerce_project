<template>
  <div>
    <ul>
      <li v-for="order in orders" v-bind:key="order">
        <Order v-bind:orderList="order" v-on:delete="deleteOrder"></Order>
      </li>
    </ul>
  </div>

</template>

<script>


import {fetchOrders, deleteOrders} from "@/api/order";
import Order from "@/components/Order";


export default {
  name: "OrderList",
  components: {Order},
  created() {
    this.fetchData()
  },
  data : function ()
  {
    return {
      orders : [],
      componentKey:0
    }
  },
  methods : {
    async fetchData()
    {
      const {data} = await fetchOrders()
      this.orders = data.content;
    },
    async deleteOrder(orderId)
    {
      await deleteOrders(orderId);
      this.$router.go(this.$router.currentRoute);
    }
  },


}
</script>

<style scoped>

</style>
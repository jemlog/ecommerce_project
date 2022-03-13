<template>
  <div class="orderBox">
    <ul>
      <li>상품명 : {{orderList.itemName}}</li>
      <li>구매자 : {{orderList.username}}</li>
      <li>총구매가격 : {{orderList.totalOrderPrice}}</li>
      <li>주문 번호 : {{orderList.orderId}}</li>
      <li>주문 상태 : {{orderList.orderState}}</li>
    </ul>
    <v-btn color="warning" v-on:click="deleteList">삭제</v-btn>
  </div>

</template>

<script>
export default {
  name: "Order",
  props : ['orderList'],
  methods : {
    deleteList()
    {
      this.$emit('delete',this.orderList.orderId)
    },

  }
}
</script>

<style scoped>
.orderBox{
  display: flex;
}
</style>
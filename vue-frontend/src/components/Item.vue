<template>
<div class="itemBox">
<ul>
  <li>상품명 : {{itemprop.itemName}}</li>
  <li>재고 수량 : {{itemprop.quantity}}</li>
  <li>상품 가격 : {{itemprop.price}}</li>
</ul>
  <v-btn color="success" v-on:click="orderList">주문</v-btn>
  <v-btn color="warning" v-on:click="deleteList">삭제</v-btn>
</div>

</template>

<script>
export default {
  name: "Item",
  props : ['itemprop'],
  methods : {
    deleteList()
    {
      this.$emit('delete',this.itemprop.id)
    },
    orderList()
    {
      this.$router.push({name :"Order",query :{itemId : this.itemprop.id}} )
    }
  }
}
</script>

<style scoped>
.itemBox{
  display: flex;
}
</style>
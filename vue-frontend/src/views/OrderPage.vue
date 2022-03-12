<template>
  <div class="orderSector">
    <p class="orderLetter">주문하기</p>
    <div class="orderForm">
      <OrderForm v-bind:itemprop="itemId"></OrderForm>
    </div>
  </div>
</template>

<script>

import OrderForm from "@/components/OrderForm";

export default {
  name: "OrderPage",
  props : {
    itemId : {
      type: Number,
      default: 0
    }
  },
  components: {OrderForm}
}
</script>

<style>
.orderSector{
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: auto;
  padding: 20px 35px 20px 35px;
  background-color: #f1f3f5;
}
.orderForm {
  width: 400px;
  margin: auto;
  padding: 30px;
  background-color: white;
  box-shadow: 2px 5px 15px 1px  #ced4da;

}

.orderLetter{
  text-align: center;
  font-size: 2rem;
  font-family: 'Heebo', sans-serif;
}
</style>
<template>
<div class="itemBox">
<ul class="itemList">
  <v-img class="s3img" :src="itemprop.imagepath"></v-img>
  <li>상품명 : {{itemprop.itemName}}</li>
  <li>재고 수량 : {{itemprop.quantity}}</li>
  <li>상품 가격 : {{itemprop.price}}</li>

</ul>
  <div class="btns">
    <v-btn color="success" v-on:click="orderList">주문</v-btn>
    <v-btn color="warning" v-on:click="deleteList">삭제</v-btn>
  </div>
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
  border: 1px solid black;
  display: flex;
  align-items : center;
  justify-content: center;
  width : 50em;
  margin: 0 auto;
}
.itemList{
  display: flex;
  list-style: none;
  align-items: center;
  justify-content: center;

}
li {
  margin-right: 15px;
}
.btns{
  display: flex;
  padding: 10px;
  align-items: center;
  justify-content: center;
}
.s3img
{
  width: 70px;
  height: 70px;
}
</style>
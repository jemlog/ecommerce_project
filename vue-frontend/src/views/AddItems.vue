<template>
  <div class="addItemSector">
    <p class="addItemletter">item 등록</p>
    <div class="addItemForm">
      <AddItemForm></AddItemForm>
    </div>
  </div>
</template>

<script>

import AddItemForm from "@/components/AddItemForm";

export default {
  name: "AddItems",
  components : {
    AddItemForm
  }
}
</script>

<style>
.addItemSector{
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: auto;
  padding: 20px 35px 20px 35px;
  background-color: #f1f3f5;
}
.addItemForm {
  width: 400px;
  margin: auto;
  padding: 40px;
  background-color: white;
  box-shadow: 2px 5px 15px 1px  #ced4da;

}
.addItemletter{
  text-align: center;
  font-size: 2rem;
  font-family: 'Heebo', sans-serif;
}
</style>
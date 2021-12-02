<template>
<router-link :to="{name: 'Category'}">
  <button class="btn btn-primary btn-lg"> Admin Categories </button>
</router-link>
<br/>
<router-link :to="{name: 'Product'}">
  <button class="btn btn-primary btn-lg"> Admin Products </button>
</router-link>
</template>

<script>
export default {

}
</script>

<style>
.btn {
    margin-top: 20px;
}
</style>
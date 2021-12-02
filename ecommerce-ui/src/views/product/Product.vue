<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h3 class="pt-3">Products</h3>
        <router-link :to="{name:'AddProduct'}">
          <button class="btn" style="float:right"> Add Product </button>
        </router-link>
      </div>
    </div>
    <div class="row">
      <div
        v-for="product of products"
        :key="product.id"
        class="col-xl-4 col-md-6 col-12 pt-3 d-flex"
      >
        <ProductBox :product="product" />
      </div>
    </div>
  </div>
</template>

<script>
import ProductBox from '../../components/product/ProductBox.vue'

export default {
    name: 'Product',
    props:["products"],
    components:{ProductBox}
};
</script>

<style>
</style>
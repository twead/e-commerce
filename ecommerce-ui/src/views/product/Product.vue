<template>
  <div class="container">
    <div class="row">
      <h4>Products</h4>
    </div>
    <div class="row">
      <div
        v-for="product of products"
        :key="product.id"
        class="col-xl-4 col-md-6 col-12 pt-3 d-flex"
      >
        <CategoryBox :product="product" />
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
</style>
<template>
  <div class="card w-100 h-100" style="margin-top: 10px">
    <div class="embed-responsive embed-responsive-16by9">
      <img class="card-img-top embed-responsive-item" :src="product.imageUrl" alt="Card image cap" />
    </div>
    <div class="card-body">
      <h5 class="card-title">{{product.name}}</h5>
      <p class="card-text">
        {{product.description.substring(0,65)}}...
      </p>
      <a href="#" class="btn btn-primary">Go somewhere</a>
    </div>
  </div>
</template>

<script>
export default {
    name: 'ProductBox',
    props:['product'],
    methods: {}
};
</script>

<style>
.card-img-top{
  object-fit: cover;
}
</style>
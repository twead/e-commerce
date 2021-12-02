<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h3 class="pt-3">Add Product</h3>
      </div>
    </div>
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
        <form>
          <div class="form-group">
            <label> Category </label>
            <select class="form-control" v-model="categoryId" required>
              <option v-for="category in categories" :key="category.id" :value="category.id">{{category.categoryName}}</option>
            </select>
          </div>

          <div class="form-group">
            <label> Name </label>
            <input type="text" class="form-control" v-model="name" required />
          </div>
          <div class="form-group">
            <label> Description </label>
            <textarea type="text" class="form-control" v-model="description" required />
          </div>
          <div class="form-group">
            <label> Image </label>
            <input type="text" class="form-control" v-model="imageUrl" required />
          </div>
          <div class="form-group">
            <label> Price </label>
            <input type="number" class="form-control" v-model="price" required />
          </div>
          <button type="submit" class="btn btn-primary" @click="addProduct">
            Submit
          </button>
        </form>
      </div>
      <div class="col-3"></div>
    </div>
  </div>
</template>

<script>
const axios = require("axios");
const sweetalert = require("sweetalert");
export default {
  props:[
    "baseURL",
    "categories"
  ],
  data() {
    return {
      id: null,
      categoryId: null,
      name: null,
      description: null,
      imageUrl: null,
      price: null
    };
  },
  methods: {
    addProduct() {
      const newProduct = {
        categoryId: this.categoryId,
        name: this.name,
        description: this.description,
        imageUrl: this.imageUrl,
        price: this.price
      };

      axios.post(this.baseURL+"/product/create", newProduct)
      .then(()=> {
        this.$router.push({name: 'AdminProduct'})
          sweetalert({
              text: 'Product added successfully',
              icon: 'success'
          });
      }).catch(err => {
          console.log(err);
      })

    },
  },
};
</script>

<style>
</style>
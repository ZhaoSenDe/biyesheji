<template>
  <div id="app">

  <router-view class="con">

  </router-view>

  </div>
</template>

<script>

import Login from "./views/login/Login";
export default {
  name: 'app',
  components: {Login}
}
</script>

<style>
.con{
  height: 100%;
}
.c {
  height: 100%;
}
</style>

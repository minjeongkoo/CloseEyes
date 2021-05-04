<template>
  <div id="app">
    <app-header/>
    <router-view/>
  </div>
</template>

<script>
import Header from "@/components/Header"

export default {
  components: {
    'app-header': Header,
  }
}

</script>

<style src="./style/common.css"></style>
<style src="./style/style.css"></style>
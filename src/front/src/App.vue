<template>
  <div id="app">
    <app-header/>
    <div class="content">
      <router-view/>
    </div>
    <app-footer/>
  </div>
</template>

<script>
import Header from "@/components/Header"
import Footer from "@/components/footerArea"

export default {
  components: {
    'app-header': Header,
    'app-footer': Footer
  }
}

</script>
<!-- Style -->
<link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
<style src="./style/common.css"></style>
<style src="./style/style.css"></style>
<style src="./style/responsive.css"></style>

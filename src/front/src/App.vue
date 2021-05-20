<template>
  <div id="app">
    <app-header/>
    <div class="contentArea">
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

<style src="./style/common.css"></style>
<style src="./style/style.css"></style>
<style src="./style/responsive.css"></style>

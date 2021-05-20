<template>
  <div id="app">
    {{ saveUsersTheme() }}
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
const userModeInfo = window.matchMedia('(prefers-color-scheme: Dark)').matches;

export default {
  components: {
    'app-header': Header,
    'app-footer': Footer
  },
  methods: {
    saveUsersTheme: function () {
      // Dark Mode  : userModeInfo == true
      // Light Mode : userModeInfo == false

      if ( userModeInfo == true ) {
        // Dark Mode
        let userMode = 'dark';
        localStorage.setItem("userMode", userMode);
      } else {
        // Light Mode
        let userMode = 'light';
        localStorage.setItem("userMode", userMode);
      }
      this.autoSetServiceTheme();
    },
    autoSetServiceTheme: function () {
      if ( localStorage.getItem('userMode') == 'dark' ){
        let bodyObject = document.getElementsByTagName('body')[0];
        bodyObject.className += "darkMode"
      }
    }
  }
}

</script>
<!-- Style -->
<style src="./style/common.css"></style>
<style src="./style/style.css"></style>
<style src="./style/responsive.css"></style>

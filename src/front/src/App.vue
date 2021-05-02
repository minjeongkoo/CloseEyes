<template>
  <app-header/>
  <router-view/>
</template>

<script>
import Header from "@/components/Header";

export default {
  components: {
    'app-header': Header,
  }
}
</script>

<style>
@import url(//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css);

#app {
  font-family: 'Spoqa Han Sans Neo', 'sans-serif';
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

body {
  /*background: red;*/
  padding-left: 320px;
  padding-right: 320px;
  background: #FAFAFA;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>

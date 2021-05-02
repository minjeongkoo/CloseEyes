<template>
  <div class="mylist">
    <h1>This is an Mylist view</h1>
  </div>
</template>

<script>
import request from 'request'

export default {
  mounted() {
    request('http://localhost:8080/api/hello',function (error, response, data) {
      window.console.log('url:', this.uri.href);
      if(error !== null) {
        window.console.log('error:', error);
      }
      window.console.log('response', response && response.statusCode);
      window.console.log('data:', data);
    });
  }
}
</script>
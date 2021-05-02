<template>
  <div class="controllArea">
    <!-- theme -->
    <div>
      <span>Theme</span>
      <select>
        <option value="darkTheme">Dark Theme 🌒</option>
        <option value="lightTheme">Light Theme 🌖</option>
      </select>
    </div>
    <!-- language -->
    <div>
      <span>Language</span>
      <select v-model="lang" @change="handleChange($event)">
        <option value="kor">한국어</option>
        <option value="jpn">日本語</option>
      </select>
    </div>
  </div>

</template>

<script>
export default {
  name: "Header.vue",
  // data: function () {
  //   const lang = localStorage.getItem('lang') || 'kor';
  //   return {
  //     lang: lang
  //   }
  // },
  // methods: {
  //   handleChange(event) {
  //     console.log('testing');
  //     localStorage.setItem('lang', event.target.value);
  //     window.location.reload()
  //   }
  // }
}
</script>

<style scoped>

.controllArea {
  display: flex;
  justify-content: right;
  position: absolute;
  right: 16px;
  height: auto;
  text-align: right !important;
}

.controllArea button {
  margin-left: 8px;
}

.controllArea span {
  margin-left: 16px;
  margin-right: 8px;
  font-size: 16px;
  line-height: 36px;
}

.controllArea select {
  min-width: 120px;
  height: 32px;
  padding-left: 8px;
  padding-right: 8px;
}

</style>
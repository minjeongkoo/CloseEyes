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
    }
  },
  mounted() {

    const selectorOject = document.getElementById('themeSelector');

    // 옵션 태그들의 selected 속성 전부 초기화
    selectorOject[0].removeAttribute('selected');
    selectorOject[1].removeAttribute('selected');
    selectorOject[2].removeAttribute('selected');

    // localstorage 에 있는 값을 기준으로 태그들에 selecred 속성 추가.
    switch (localStorage.getItem('setMode')) {
      case 'light' :    selectorOject[1].setAttribute('selected', '');
                        break;
      case 'dark'  :    selectorOject[2].setAttribute('selected', '');
                        break;
    }

    const bodyObject = document.getElementsByTagName('body')[0];

    if (localStorage.getItem('setMode') !== null) {
      // 처음 로드시 유저가 테마를 세팅해놓은 정보가 있을 때. 동작 안함.
      if (localStorage.getItem('setMode') == 'dark') {
        bodyObject.className = "darkMode";
      } else {
        odyObject.className = "";
        bodyObject.removeAttribute('class');
      }

    } else {
      // 처음 로드시 setMode 데이터 비어있을 때.
      if (localStorage.getItem('userMode') == 'dark') {
        bodyObject.className = "darkMode";
      } else {
        bodyObject.className = "";
        bodyObject.removeAttribute('class');
      }
    }
  }

}

</script>
<!-- Style -->
<style src="./style/common.css"></style>
<style src="./style/style.css"></style>
<style src="./style/responsive.css"></style>

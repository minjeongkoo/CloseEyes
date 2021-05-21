<template>
  <div class="controllArea">
    <div>
      <img v-show="hideBackButton" src="../assets/images/ico/ico_arrow_back.svg" onclick="history.back();"
           v-on:mouseover="backTextModal = true" v-on:mouseleave="backTextModal = false"/>
      <div class="modalTextBox" v-show="backTextModal">뒤로가기</div>
    </div>
    <!-- theme -->
    <div>
      <select @change="changeTheme($event)">
        <option> 테마를 설정해보세요 !</option>
        <option value="light">  Light Theme     </option>
        <option value="dark">   Dark Theme      </option>
        <option value="osSet">  Device Setting  </option>
      </select>
    </div>
  </div>
</template>

<script>
// Back Navigation  | 유저의 위치 확인 & modal 상태값 기본 상태
const locationCheck = location.pathname !== '/';
const backTextModal = false;

// User Theme Select Event and Reset Theme at O/S Default
  let setMode;
  let bodyObject = document.getElementsByTagName('body')[0];


module.exports = {
  data: function () {
    return {
      hideBackButton: locationCheck,
      backTextModal:  backTextModal
    }
  },
  methods: {
    changeTheme($event) {

      // setMode Reset
      setMode = '';

      // Chance Data of LocalStorage 'setMode' Key's Value
      if (event.target.value == 'light') {

        // Select Light Mode
        setMode = 'light';
        localStorage.setItem('setMode',setMode);
        // console.log('setMode, light');

      } else if (event.target.value == 'dark') {

        // Select Dark Mode
        setMode = 'dark';
        localStorage.setItem('setMode',setMode);
        // console.log('setMode, dark');

      } else if (event.target.value == 'osSet') {

        // Select O/S Setting
        localStorage.removeItem('setMode');
        this.autoSetServiceTheme();

      }

      this.setChangeTheme(setMode);
    },
    setChangeTheme(setModeStatus) {

      if (setModeStatus == 'dark') {

        bodyObject.className = "";
        bodyObject.className += "darkMode";

      } else if (setModeStatus == 'light') {

        bodyObject.className = "";

      }
    },
    autoSetServiceTheme() {
      if ( localStorage.getItem('userMode') == 'dark' ){
        bodyObject = document.getElementsByTagName('body')[0];
        bodyObject.className = "";
        bodyObject.className += "darkMode";
      } else {
        bodyObject = document.getElementsByTagName('body')[0];
        bodyObject.className = "";
      }
    }
  }
}

</script>
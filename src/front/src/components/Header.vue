<template>
  <div class="controllArea">

    <!-- Button Back -->
    <div>
      <!-- SVG -->
      <div v-show="hideBackButton" onclick="history.back();" v-on:mouseover="backTextModal = true" v-on:mouseleave="backTextModal = false">
        <svg id="arrow_back_black_24dp" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
          <path id="path_7" data-name="path 7" d="M0,0H24V24H0Z" fill="none"/>
          <path id="path_8" data-name="path 8" d="M19,11H7.83l4.88-4.88a1.008,1.008,0,0,0,0-1.42,1,1,0,0,0-1.41,0L4.71,11.29a1,1,0,0,0,0,1.41l6.59,6.59a1,1,0,0,0,1.41-1.41L7.83,13H19a1,1,0,0,0,0-2Z" fill="var(--ow-black)"/>
        </svg>
      </div>
      <!-- modal -->
      <div class="modalTextBox" v-show="backTextModal">뒤로가기</div>
    </div>
    <!-- Setting Theme -->
    <div>
      <select   @change="changeTheme($event)" id="themeSelector">
        <option value="osSet"         >  디바이스 설정 테마    </option>
        <option value="light"         >  Light Theme      </option>
        <option value="dark"          >  Dark Theme       </option>
      </select>
    </div>

  </div>
</template>

<script>
// Back Navigation  | 유저의 위치 확인 & modal 상태값 기본 상태
const locationCheck       = location.pathname !== '/';
const backTextModal       = false;

// User Theme Select Event and Reset Theme at O/S Default
const bodyObject          = document.getElementsByTagName('body')[0];
let setThemeStatus        = localStorage.getItem('setMode');


module.exports = {
  data: function () {
    return {
      hideBackButton: locationCheck,
      backTextModal: backTextModal,
    }
  },
  methods: {
    changeTheme($event) {

      // Select    :: Light | Dark | OS
      // Function  :: Chance Data of LocalStorage 'setMode' Key's Value
      if (event.target.value === 'light') {

        // Select Light Mode
        localStorage.setItem('setMode','light');
        this.setChangeTheme();

      } else if (event.target.value === 'dark') {

        // Select Dark Mode
        localStorage.setItem('setMode','dark');
        this.setChangeTheme();


      } else if (event.target.value === 'osSet') {

        // Select O/S Setting
        localStorage.removeItem('setMode');
        this.autoSetServiceTheme();

      }

    },
    setChangeTheme() {

      if      ( localStorage.getItem('setMode') === 'dark'   ) { bodyObject.className = "darkMode";  }
      else if ( localStorage.getItem('setMode') === 'light'  ) { bodyObject.className = "";          }

    },
    autoSetServiceTheme() {
      if ( localStorage.getItem('userMode') === 'dark' ){
        bodyObject.className = "darkMode";
      } else {
        bodyObject.className = "";
        bodyObject.removeAttribute('class');
      }
    }
  }
}

</script>
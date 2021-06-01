<template>
  <header>
    <div>
      <!-- Logo -->
      <div>
        <router-link to="/">
          <img style="margin-top: 10px" src="../assets/images/home-logo.svg">
        </router-link>
      </div>

      <div class="header-menu">
        <div>
          <router-link to="/">
            <img src="../assets/images/header-home.svg">
          </router-link>
        </div>
        <div>
          <router-link to="/mylist">
            <img src="../assets/images/header-mylist.svg">
          </router-link>
        </div>
        <div>
          <router-link to="/writing">
            <img src="../assets/images/header-write.svg">
          </router-link>
        </div>
      </div>
      <div class="set-menu">
        <span>환경설정 </span>
        <div class="icon">
          <img v-on:click="setModalOn" v-if="setIcoStatus" src="../assets/images/ico/ico_setting.svg"/>
          <img v-on:click="setModalOff" v-if="setIcoClose" src="../assets/images/ico/ico_setting.svg"/>
        </div>
        <!-- set menu modal -->
        <div class="set-menu-modal" v-show="setModalStatus">
          <h6>Theme</h6>
          <p v-on:click="setThemeMode('os')">디바이스 설정</p>
          <p v-on:click="setThemeMode('light')">밝은 테마</p>
          <p v-on:click="setThemeMode('dark')">어두운 테마</p>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
const rootObject = document.getElementsByTagName('body')[0];
const osSetTheme = window.matchMedia('(prefers-color-scheme: Dark)').matches;

export default {
  data: function () {
    return {
      setModalStatus: false,
      setIcoStatus: true,
      setIcoClose: false
    }
  },
  methods: {
    setModalOn() {
      this.setModalStatus = true;
      this.setIcoStatus = false;
      this.setIcoClose = true;
    },
    setModalOff() {
      this.setModalStatus = false;
      this.setIcoClose = false;
      this.setIcoStatus = true;
    },
    setThemeMode(mode) {
      // console.log(mode);
      switch (mode) {
        case 'os':      if ( osSetTheme === true ) {
                            // console.log('os, dark');
                            localStorage.setItem('themeMode','dark')
                        } else {
                            // console.log('os, light');
                            localStorage.setItem('themeMode','light')
                        }
                        location.reload();
                        break;
        case 'light':   localStorage.setItem('themeMode','light');
                        location.reload();
                        break;
        case 'dark':    localStorage.setItem('themeMode', 'dark');
                        location.reload();
                        break;
      }
    }
  },
  mounted() {
    if ( localStorage.getItem('themeMode') === 'dark' ) {
      rootObject.classList = 'darkMode';
    } else {
      rootObject.removeAttribute('class');
    }
  }
}

</script>

<style>
header {
  display: flex;
  padding-left: 20%;
  padding-right: 20%;
  padding-top: 16px;
  padding-bottom: 16px;
}

header>div {
  display: flex;
  justify-content: space-between;
  width: 100%;
}

.header-menu {
  display: flex;
}

.header-menu>div {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100px;
  height: 70px;
  border-radius: 10px;
}

.set-menu {
  display: flex;
}

.set-menu .icon {
  display: inline-flex;
  align-items: center;
  height: 100%;
}

.set-menu span {
  margin-right: 12px;
  line-height: 70px;
  color: var(--ow-blue);
}

.set-menu-modal {
  display: block;
  width: 120px;
  text-align: left;
  padding-left: 16px;
  padding-right: 16px;
  color: var(--ow-blue);
  background: var(--ow-default);
  box-shadow: rgb(55 71 79 / 30%) 0px 1px 3px;
  position: absolute;
  top: 72px;
  border-radius: 10px;
}

.set-menu-modal p {
  cursor: pointer;
}

..set-menu-modal p:hover {
  background: var(--ow-mint);
}


</style>
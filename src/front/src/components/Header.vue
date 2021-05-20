<template>
  <div class="controllArea">
    <div>
      <img v-show="hideBackButton" src="../assets/images/ico/ico_arrow_back.svg" onclick="history.back();" v-on:mouseover="backTextModal = true" v-on:mouseleave="backTextModal = false"/>
      <div class="modalTextBox" v-show="backTextModal">뒤로가기</div>
    </div>
    <!-- theme -->
    <div>
      <!--
      {{ themeSet() }}
      <select @change="changeTheme($event)">
        <option> 테마를 설정해보세요 ! </option>
        <option value="lightTheme"> Light Theme </option>
        <option value="darkTheme"> Dark Theme </option>
      </select>
      -->
    </div>
  </div>
</template>

<script>
// Back Navigation  | 유저의 위치 확인 & modal 상태값 기본 상태
const   locationCheck =   location.pathname !== '/';
const   backTextModal =   false;

module.exports = {
  data: function () {
    return {
      hideBackButton:   locationCheck,
      backTextModal:    backTextModal
    }
  }
}

</script>
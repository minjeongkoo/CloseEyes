<template>
  <div class="controllArea">
    <div>
      <img v-show="hideBackButton" src="../assets/images/ico/ico_arrow_back.svg" onclick="history.back();" v-on:mouseover="backTextModal = true" v-on:mouseleave="backTextModal = false"/>
      <div class="modalTextBox" v-show="backTextModal">뒤로가기</div>
    </div>
    <!-- theme -->
    <div>
      <select>
        <option value="lightTheme">🌖 밝은 테마 </option>
        <option value="darkTheme">🌒 어두운 테마 </option>
      </select>
    </div>
  </div>

</template>

<script>

const locationCheck = location.pathname !== '/'
const backTextModal = false

module.exports = {
  data: function () {
    return {
      hideBackButton: locationCheck,
      backTextModal: backTextModal
    }
  }
}

</script>
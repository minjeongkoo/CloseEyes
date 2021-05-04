<template>
  <div class="controllArea">
    <div>
      <img v-show="hideBackButton" src="../assets/images/ico/ico_arrow_back.svg" onclick="history.back();"/>
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

var locationCheck = location.pathname !== '/'

module.exports = {
  data: function () {
    return {
      hideBackButton: locationCheck
    }
  }
}

</script>
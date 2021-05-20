<template>
  <div class="fragment">
    <div>
      <H3>저장이 완료되었습니다 !</H3>
      <p>확인 버튼을 누르면 홈으로 이동합니다.</p>
      <div class="buttonBox">
        <button v-on:click="saved" class="btnMain">확인</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return ;
  },
  methods: {
    saved: function () {
      location.href = '/';
    }
  }
}
</script>
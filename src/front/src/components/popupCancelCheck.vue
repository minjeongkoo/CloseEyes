<template>
  <div class="fragment">
    <div>
      <H3>취소하시겠습니까?</H3>
      <p>작성하시던 내용을 잃어버릴 수 있습니다.</p>
<!--      {{propsTest.cancelModal}}{{propsTest.saveModal}}-->
      <div class="buttonBox">
        <button v-on:click="cancelWriting" class="btnSub">작성 취소하기</button>
          <button class="btnMain" v-on:click="closePopup">계속 작성하기</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['propsTest'],
  methods: {
    closePopup: function () {
      this.$emit('keepWriting', '매개변수');
    },
    cancelWriting: function () {
      location.href = "/"
    }
  }
}
</script>
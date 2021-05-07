<template>
  <div class="fragment">
    <div>
      <H3>취소하시겠습니까?</H3>
      <p>작성하시던 내용을 잃어버릴 수 있습니다.</p>
      <div class="buttonBox">
        <button class="btnSub">작성 취소하기</button>
        <slot>
          <button class="btnMain" @click="$emit('close')">계속 작성하기</button>
        </slot>
      </div>
    </div>
  </div>
</template>
<template>
  <div class="fragment">
    <div>
      <H3>취소하시겠습니까?</H3>
      <p>작성하시던 내용을 잃어버릴 수 있습니다.</p>
      <div class="buttonBox">
        <button class="btnSub">작성 취소하기</button>
        <slot>
          <button class="btnMain">계속 작성하기</button>
        </slot>
      </div>
    </div>
  </div>
</template>

<style>
.fragment {
  display: flex;
  align-items: center;
  justify-content: center;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(44, 62, 80, 0.8);
}

.fragment>div {
  width: 500px;
  height: fit-content;
  background: var(--ow-white);
  padding: 32px;
  border-radius: 16px;
}

.fragment .buttonBox {
  margin-top: 32px;
}

.fragment .buttonBox>button:nth-child(1) {
  margin-right: 16px;
}
</style>
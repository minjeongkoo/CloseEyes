<template>
  <div class="subPages">
    <img class="homeLogo-animatioon" src="../assets/images/homeLogo.svg"/>
    <br>
<!--    <H1>무슨일이 있었나요?</H1>-->
    <div>
      <div>
        <p>✍🏽 {{ now_year }}년 {{ now_month }}월 {{ now_date }}일 {{ unitList[now_day] }}요일에 작성됨</p>
      </div>
      <input type="text" class="write_title" placeholder="오늘 일기의 제목을 입력하고 tab을 눌러주세요."/><br>
      <textarea type="text" class="write_content" placeholder="오늘 있었던 일을 적어보세요."/><br>
    </div>
    <div class="mainButtonBox">
      <button v-on:click="openModal()">취소하기</button>
      <button class="btnMain" v-on:click="saveEvent()">저장하기</button>
      <app-CancelFragment v-if="checkCancel"/>
    </div>
  </div>
</template>

<script>
import cancelFragement from "@/components/cancelFragemnt"

// Today's Date
const writeClock = new Date();
const unitList = ["일","월","화","수","목","금","토"];
let modalStatus = false;

export default {
  components: {
    'app-CancelFragment': cancelFragement,
  },
  data: function() {
    return {
      now_year: writeClock.getFullYear(),
      now_month: writeClock.getMonth(),
      now_date: writeClock.getDate(),
      now_day: writeClock.getDay(),
      now_clock: writeClock.getTime(),
      unitList: unitList,
      checkCancel: modalStatus
    }
  },
  methods: {
    openModal() {
      // this.modalStatus = true;
      debugger
      console.log('modalStatus',modalStatus)
    },
    saveEvent() {
      console.log('saveEvent()','저장이 완료되었습니다.')
      location.href = "/"
    }
  }
}

</script>

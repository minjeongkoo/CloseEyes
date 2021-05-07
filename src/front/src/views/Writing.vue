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
      <button @click="showModal = true">취소하기</button>
      <button class="btnMain" v-on:click="saveEvent()">저장하기</button>
    </div>
    <modal v-show="showModal" @close="showModal = false">
      <app-CancelFragment/>
    </modal>
  </div>
</template>

<script>
import cancelFragemnt from "@/components/cancelFragemnt"

// Today's Date
const writeClock = new Date();
const unitList = ["일","월","화","수","목","금","토"];

// Modal

export default {
  components: {
    'app-CancelFragment': cancelFragemnt,
  },
  data() {
    return {
      now_year: writeClock.getFullYear(),
      now_month: writeClock.getMonth(),
      now_date: writeClock.getDate(),
      now_day: writeClock.getDay(),
      now_clock: writeClock.getTime(),
      unitList: unitList,
      showModal: false
      // needCancel: needCancel
    }
  },
  methods: {
  }
}

</script>

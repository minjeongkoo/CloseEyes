<template>
  <div class="subPages">
    <img class="homeLogo-animatioon" src="../assets/images/homeLogo.svg"/>
    <br>
    <!-- 작성 영역 -->
    <div>
      <!-- 작성일 표시 -->
      <div>
        <p>✍🏽 {{ timeData.now_year }}년 {{ timeData.now_month+1 }}월 {{ timeData.now_date }}일 {{ timeData.unitList[timeData.now_day] }}요일에 작성됨</p>
      </div>
      <!-- 제목 & 본문 입력 -->
      <input type="text" class="write_title" placeholder="오늘 일기의 제목을 입력하고 tab을 눌러주세요."/><br>
      <textarea type="text" class="write_content" placeholder="오늘 있었던 일을 적어보세요."/><br>
    </div>
    <!-- display.flex 버튼 -->
    <div class="mainButtonBox">
      <button v-on:click="fragmentStatus.cancelModal=!fragmentStatus.cancelModal">취소하기</button>
      <button class="btnMain" v-on:click="saveEvent()">저장하기</button>
    </div>
    <!-- 팝업 -->
      <modal-cancel v-if="fragmentStatus.cancelModal" :propsTest="fragmentStatus" @keepWriting="closeModal" class="showModalEpect"></modal-cancel>
  </div>
</template>

<script>
import popupCancelCheck from "@/components/popupCancelCheck"

// Today's Date
const writeClock = new Date();
const unitList = ["일","월","화","수","목","금","토"];
let status = false

export default {
  components: {
    'modal-cancel': popupCancelCheck,
  },
  data: function () {
    return {
      timeData: {
        now_year: writeClock.getFullYear(),
        now_month: writeClock.getMonth(),
        now_date: writeClock.getDate(),
        now_day: writeClock.getDay(),
        now_clock: writeClock.getTime(),
        unitList: unitList
      },
      fragmentStatus: {
        cancelModal: false,
        saveModal: false
      }
    }
  },
  methods: {
    saveEvent() {
      console.log('saveEvent()', '저장이 완료되었습니다.')
      location.href = "/"
    },
    closeModal(test) {
      console.log(test);
      this.fragmentStatus.cancelModal = false;
    },
  }
}

console.log(status)

</script>

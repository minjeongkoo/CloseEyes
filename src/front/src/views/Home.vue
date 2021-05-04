<template>
  <div class="homeView">
    <!-- BI Area -->
    <img class="homeLogo-animatioon" src="../assets/images/homeLogo.svg"/>
    <br>
    <H1>편안한 꿈 꾸세요.</H1>
    <!-- user info -->
    <div class="todayInfoList">
      <span>
        <b>오늘은 {{ todayDateyear }}년 {{ todayDateMonth }}월 {{ todaysUnit[todayDateUnit] }}요일 입니다. </b>         <br>
        지금까지 n개의 일기를 작성하셨네요.  <br>
        앞으로도 꾸준히 작성해주세요!
      </span>
    </div>
    <!-- Button Box Area -->
    <div class="mainButtonBox">
      <button class="btnSub" onclick="location.href='mylist'">전체 일기 목록</button>
      <button class="btnMain" onclick="location.href='writing'">오늘 일기 작성하기</button>
    </div>
  </div>
</template>

<script>

// Today's Date

const todayDate = new Date();
const todaysUnit = ["일","월","화","수","목","금","토","일"];

console.log(todayDate);
export default {
  data() {
    return {
      todayDateyear: todayDate.getFullYear(),
      todayDateMonth: todayDate.getMonth(),
      todayDateDay: todayDate.getDate(),
      todayDateUnit: todayDate.getDay(),
      todaysUnit: todaysUnit
    }
  }
}
console.log('todayDate.getDay():', todayDate.getDay());

</script>

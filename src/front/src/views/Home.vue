<template>
    <div class="homeView">
      <div class="space-100"></div>
      <h1>오늘의 이야기를 들려주세요</h1>
      <span>반갑습니다! 오늘은 {{ todayDateyear }}년 {{ todayDateMonth }}월 {{ todayDateDay }}일 {{ todaysUnit[todayDateUnit] }}요일 입니다.<br> 어떤 이야기를 들려주실껀가요?<br></span>
      <div class="buttonBox">
        <router-link to="/writing" class="btn btnMain">새 일기 작성하기</router-link>
      </div>
      <div class="overvie-card-ui">
        <!-- overview -->
        <div class="overview-card">
          <p class="overview-card-subtitle">Total_my_day</p>
          <p class="overvie-card-title">지금까지 적은 일기갯수</p>
          <div style="display: flex; justify-content: space-between">
            <span style="font-weight: 300; font-size: 26px;">999+</span>
            <router-link to="/mylist" >전체 일기 보기</router-link>
          </div>
        </div>
        <div class="overview-card">
          <p class="overview-card-subtitle">Total_my_day</p>
          <p class="overvie-card-title">지금까지 적은 일기갯수</p>
          <div style="display: flex; justify-content: space-between">
            <span style="font-weight: 300; font-size: 26px;">999+</span>
            <router-link to="/mylist">전체 일기 보기</router-link>
          </div>
        </div>
        <div class="overview-card">
          <p class="overview-card-subtitle">Total_my_day</p>
          <p class="overvie-card-title">지금까지 적은 일기갯수</p>
          <div style="display: flex; justify-content: space-between">
            <span style="font-weight: 300; font-size: 26px;">999+</span>
            <router-link to="/mylist">전체 일기 보기</router-link>
          </div>
        </div>
      </div>

    </div>
</template>

<script>

import axios from "axios";

let todayDate = new Date();
const todaysUnit = ["일","월","화","수","목","금","토","일"];


export default {
  data() {
    return {
      todayDateyear   : todayDate.getFullYear(),
      todayDateMonth  : todayDate.getMonth()+1,
      todayDateDay    : todayDate.getDate(),
      todayDateUnit   : todayDate.getDay(),
      todaysUnit      : todaysUnit,
      myTotal         : Number
    }
  },
  mounted() {
    axios.get('api/diary')
    .then(response => {
      console.log(response);
      this.myTotal = response.data.length;
    })
    .catch(function (error) {
      console.log(error);
    })
  }
}

</script>

<style>
.homeView span {
  font-size: 20px;
}

.homeView .space-100 {
  height: 100px;
}

.homeView .buttonBox {
  margin-top: 50px;
}

.overvie-card-ui {
  display: flex;
  justify-content: center;
  margin-top: 72px;
}

.overview-card {
  display: inline-block;
  margin-right: 8px;
  margin-left: 8px;
  width: 280px;
  padding: 30px;
  background: var(--ow-background);
  box-shadow: rgb(00 00 00 / 10%) 0px 3px 6px;
  border-radius: 30px;
  text-align: left;
}

.overview-card-subtitle {
  color: #EB516B;
  font-size: 12px;
  font-weight: 600;
}

.overvie-card-title {
  font-size: 20px;
  font-weight: 600;
}

</style>

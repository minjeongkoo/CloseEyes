<template>
    <div class="homeView">

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

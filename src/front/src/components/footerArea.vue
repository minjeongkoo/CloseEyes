<template>
  <footer>
    <!-- Support Info -->
    <div>
      <div v-on:click="openGithubUrl">
        <img src="../assets/images/ico/ico_free.png">
        <span>License</span>
      </div>
      <div v-on:click="openKenzoMail">
        <img src="../assets/images/ico/ico_letter.png">
        <span>문제 신고 & 기능 문의</span>
      </div>
      <div>
        <span>Rekenzo_</span>
      </div>
    </div>
  </footer>
</template>

<script>
// New Window Url
// function openGithubUrl() {
//   console.log("run")
//   window.open("https://github.com/minjeongkoo/owproject","","width=100%")
// }

export default {
  data() {
    return;
  },
  methods: {
    openGithubUrl() {
      window.open("https://github.com/minjeongkoo/owproject");
    },
    openKenzoMail() {
      window.open("https://github.com/minjeongkoo/owproject");
    }

  }
}

</script>
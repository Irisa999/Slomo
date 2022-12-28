<template>
  <div>
    <a @click="openLink">+ Add Shop </a>
  </div>
</template>

<script>
export default {
  methods: {
    openLink() {
      window.open('https://storerocket.io/app/locations?view=all&sortField=created_at&sortDirection=desc', '_blank');
    },
  },
};
</script>

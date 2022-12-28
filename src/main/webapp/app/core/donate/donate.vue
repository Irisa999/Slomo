<template>
  <div
    id="storerocket-widget"
    style="width: 100%"
    :data-storerocket-filters="filters"
    :data-storerocket-env="env"
    :data-storerocket-id="id"
  >
    <p style="text-align: center; font-size: 13px; padding: 10px">
      {{ message }}
    </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      filters: 110785,
      env: 'p',
      id: 'Ly8G3a98r0',
      message: 'Store locator is loading...',
    };
  },
  mounted() {
    (function () {
      var script = document.createElement('script');
      script.type = 'text/javascript';
      script.async = true;
      script.src = 'https://cdn.storerocket.io/js/widget.js';
      var firstScript = document.getElementsByTagName('script')[0];
      firstScript.parentNode.insertBefore(script, firstScript);
    })();
  },
};
</script>

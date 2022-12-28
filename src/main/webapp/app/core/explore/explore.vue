<template>
  <div>
    <!-- Store locator widget -->
    <div id="storerocket-widget" style="width: 100%" data-storerocket-env="p" data-storerocket-id="Ly8G3a98r0">
      <p style="text-align: center; font-size: 13px; padding: 10px">
        Store locator is loading...
        <a target="_blank" href="https://storerocket.io" style="font-size: 13px"> Explore Locator </a>..
      </p>
    </div>
  </div>
</template>

<script>
export default {
  mounted() {
    // Load the StoreRocket store locator widget
    (function () {
      var a = document.createElement('script');
      a.type = 'text/javascript';
      a.async = true;
      a.src = 'https://cdn.storerocket.io/js/widget.js';
      var b = document.getElementsByTagName('script')[0];
      b.parentNode.insertBefore(a, b);
    })();
  },
};
</script>

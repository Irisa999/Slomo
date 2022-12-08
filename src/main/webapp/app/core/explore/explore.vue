<template>
  <div class="home row">
    <!-- Explore section -->
    <div class="col-md-9">
      <h1 class="display-4">Welcome to Explore!</h1>
      <p class="lead">These are the shops near you! Please enter a city to get your preferred results :)</p>
      <div>
        <input type="text" v-model="city" placeholder="Enter a city" />
        <button v-on:click="searchStores()">Search</button>
        <ul v-if="stores.length > 0">
          <li v-for="store in stores">
            {{ store }}
          </li>
        </ul>
        <ul v-if="showStores">
          <li v-for="store in stores">
            {{ store }}
          </li>
        </ul>
      </div>
    </div>

    <div>
      <div class="map" ref="map"></div>

      <ul>
        <li v-for="store in stores" :key="store.id">
          {{ store.name }}
          <div v-if="store.distance">({{ store.distance }} km away)</div>
        </li>
      </ul>
    </div>
    <!-- End Explore Section -->
  </div>
</template>

<script lang="ts" src="./explore.component.ts"></script>

<script>
export default {
  data() {
    return {
      lat: 0, // Initial latitude
      lng: 0, // Initial longitude
      stores: [], // Initial list of stores
    };
  },
  mounted() {
    // Get the user's current location
    navigator.geolocation.getCurrentPosition(position => {
      // Set the user's latitude and longitude
      this.lat = position.coords.latitude;
      this.lng = position.coords.longitude;

      // Search for stores near the user's location
      this.searchStores();

      // Initialize the map
      this.initMap;
    });
  },
};
</script>

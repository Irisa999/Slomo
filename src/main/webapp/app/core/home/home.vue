<template>
  <div class="home row">
    <!-- ======= Hero Section ======= -->
    <section id="hero" class="d-flex align-items-center">
      <div class="container">
        <div class="row">
          <div
            class="col-lg-6 d-flex flex-column justify-content-center pt-4 pt-lg-0 order-2 order-lg-1"
            data-aos="fade-up"
            data-aos-delay="200"
          >
            <h1>Slow Fashion Movement</h1>
            <h2>"As consumers, we have so much power to change the world by just being careful in what we buy."</h2>
            <div class="d-flex justify-content-center justify-content-lg-start">
              <a href="./home.vue" class="btn-get-started scrollto">Get Started</a>
            </div>
          </div>
          <div class="col-lg-6 order-1 order-lg-2 home-img" data-aos="zoom-in" data-aos-delay="200">
            <img src="content/images/home-img.png" class="img-fluid animated" alt="" />
          </div>
        </div>
      </div>
    </section>
    <!-- End Hero -->

    <!-- ======= About Us Section ======= -->
    <section id="about" class="about">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>About Us</h2>
        </div>

        <div class="row content">
          <div class="col-lg-6">
            <p>
              Slomo is a web-based business that works with slow-moving brands and retailers. You may look for the location of any store you
              choose in the city of your choice. This service aims to increase the number of people who shop in slow-moving stores rather
              than fast-moving businesses, which benefits the environment in many ways:
            </p>
            <ul>
              <li><i class="ri-check-double-line"></i> Reduces your carbon footprint & requires less water</li>
              <li><i class="ri-check-double-line"></i> Saves natural resources & animal lives</li>
              <li><i class="ri-check-double-line"></i> Supports fairer & safer working conditions</li>
            </ul>
          </div>
          <div class="col-lg-6 pt-4 pt-lg-0">
            <p>Write smth also here!!!</p>
            <a href="#" class="btn-learn-more">Learn More</a>
          </div>
        </div>
      </div>
    </section>
    <!-- End About Us Section -->

    <!-- ======= Frequently Asked Questions Section ======= -->
    <section id="faq" class="faq section-bg">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>Frequently Asked Questions</h2>
          <p>Hey so below are listed the questions.</p>
        </div>

        <div class="faq-list">
          <ul>
            <li data-aos="fade-up" data-aos-delay="100">
              <i class="bx bx-help-circle icon-help"></i>
              <a data-bs-toggle="collapse" class="collapse" data-bs-target="#faq-list-1"
                >Question 1? <i class="bx bx-chevron-down icon-show"></i><i class="bx bx-chevron-up icon-close"></i
              ></a>
              <div id="faq-list-1" class="collapse show" data-bs-parent=".faq-list">
                <p>Answer 1.</p>
              </div>
            </li>

            <li data-aos="fade-up" data-aos-delay="200">
              <i class="bx bx-help-circle icon-help"></i>
              <a data-bs-toggle="collapse" data-bs-target="#faq-list-2" class="collapsed"
                >Question 2? <i class="bx bx-chevron-down icon-show"></i><i class="bx bx-chevron-up icon-close"></i
              ></a>
              <div id="faq-list-2" class="collapse" data-bs-parent=".faq-list">
                <p>Answer 2.</p>
              </div>
            </li>

            <li data-aos="fade-up" data-aos-delay="300">
              <i class="bx bx-help-circle icon-help"></i>
              <a data-bs-toggle="collapse" data-bs-target="#faq-list-3" class="collapsed"
                >Question 3? <i class="bx bx-chevron-down icon-show"></i><i class="bx bx-chevron-up icon-close"></i
              ></a>
              <div id="faq-list-3" class="collapse" data-bs-parent=".faq-list">
                <p>Answer 3.</p>
              </div>
            </li>

            <li data-aos="fade-up" data-aos-delay="400">
              <i class="bx bx-help-circle icon-help"></i>
              <a data-bs-toggle="collapse" data-bs-target="#faq-list-4" class="collapsed"
                >Question 4? <i class="bx bx-chevron-down icon-show"></i><i class="bx bx-chevron-up icon-close"></i
              ></a>
              <div id="faq-list-4" class="collapse" data-bs-parent=".faq-list">
                <p>Answer 4.</p>
              </div>
            </li>

            <li data-aos="fade-up" data-aos-delay="500">
              <i class="bx bx-help-circle icon-help"></i>
              <a data-bs-toggle="collapse" data-bs-target="#faq-list-5" class="collapsed"
                >Question 5? <i class="bx bx-chevron-down icon-show"></i><i class="bx bx-chevron-up icon-close"></i
              ></a>
              <div id="faq-list-5" class="collapse" data-bs-parent=".faq-list">
                <p>Answer 5.</p>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </section>
    <!-- End Frequently Asked Questions Section -->
  </div>
</template>

<script lang="ts" src="./home.component.ts"></script>

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

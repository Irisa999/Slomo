package com.slomoproject.myapp.repository;


import com.slomoproject.myapp.domain.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findShopsByCity(String city);
    List<Shop> findAllByDonationsIsFalse();
    List<Shop> findShopsByDonationsIsTrue();
    Page<Shop> findAllByNameContainsIgnoreCase(Pageable pageable);
}

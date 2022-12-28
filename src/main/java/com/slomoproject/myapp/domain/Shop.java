package com.slomoproject.myapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "shop")
public class Shop extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @JsonProperty("id")
    private Long id;

    @Size(max = 50)
    @NonNull
    @JsonProperty("name")
    @Column(length = 50)
    private String name;

    @Size(max = 50)
    @NonNull
    @JsonProperty("category")
    @Column(length = 50)
    private String category;

    @Size(max = 15)
    @NonNull
    @JsonProperty("country")
    @Column(length = 15)
    private String country;

    @Size(max = 15)
    @NonNull
    @JsonProperty("city")
    @Column(length = 15)
    private String city;

    @Size(max = 15)
    @NonNull
    @JsonProperty("address")
    @Column(length = 15)
    private String address;

    @Size(max = 15)
    @NonNull
    @JsonProperty("postalCode")
    @Column(length = 15)
    private String postalCode;

    @JsonProperty("validated")
    private Boolean validated = false;

    @Size(max = 255)
    @JsonProperty("description")
    @Column(length = 255)
    private String description;

    @Size(max = 2)
    @JsonProperty("rating")
    @Column(length = 2)
    private Integer rating = Integer.valueOf(0);

    private Boolean donations = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Boolean getDonations() {
        return donations;
    }

    public void setDonations(Boolean donations) {
        this.donations = donations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Shop shop = (Shop) o;
        return id != null && Objects.equals(id, shop.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

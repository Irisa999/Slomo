package com.slomoproject.myapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
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

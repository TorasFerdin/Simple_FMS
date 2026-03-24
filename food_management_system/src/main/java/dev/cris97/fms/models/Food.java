package dev.cris97.fms.models;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false, insertable = false)
    private String uuid;

    @Column(name = "food_name", nullable = false)
    private String name;

    private String category;
    private Integer calories;

    @Column(precision = 6, scale = 2)
    private BigDecimal price;

    private boolean available;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;


    public Food(){

    }


    public Long getId() {
        return id;
    }
    public String getUuid() {
        return uuid;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public Integer getCalories() {
        return calories;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public boolean isAvailable() {
        return available;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCalories(Integer calories) {
        this.calories = calories;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

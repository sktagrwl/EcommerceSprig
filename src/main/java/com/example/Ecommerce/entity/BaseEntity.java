package com.example.Ecommerce.entity;

//Importing JPA annotation like @Id, @Column used for mapping class to a db structure
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Instant class from Java Time Api > represents the timestamp in UTC
import java.time.Instant;

//is JPA annotation used to define the base class that contains the common fields
//which will be inherited and mapped into child entity table
//unlike @entity > it does not ger its own table
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)//works with @EnableJpaAuditing on application class
@Getter
@Setter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    //This method us automatically called before the entity is saved for the first time
    @PrePersist
    public void onCreate() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = Instant.now();
    }
}

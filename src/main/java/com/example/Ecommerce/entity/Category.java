package com.example.Ecommerce.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Category extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

}

package com.example.lets_play.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String id;

    @Field("name")
    @NotBlank(message = "Name cannot be empty")
    @Size(max = 100)
    private String name;

    @Field("description")
    @Size(max = 500)
    private String description;

    @Field("price")
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @Field("userId")
    private String userId;
}
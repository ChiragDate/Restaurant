package com.chirag.festaurant.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record ProductRequest(

        @NotNull(message = "Product name should not be null")
        @NotEmpty(message = "Product name should be present")
        @NotBlank(message = "Product name should be present")
        @JsonProperty("name")
        String name,

        @JsonProperty("price")
        Long price
) {
}

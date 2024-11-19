package com.chirag.festaurant.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponse(
        @JsonProperty("first_name")
        String name,
        @JsonProperty("last_name")
        Long price
) {
}
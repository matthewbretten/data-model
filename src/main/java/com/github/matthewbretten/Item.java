package com.github.matthewbretten;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@JsonPropertyOrder({
        "basketItemId",
        "description",
        "price"
})
public class Item {
    @JsonProperty("basketItemId")
    @NotNull
    public Integer basketItemId;

    @JsonProperty("description")
    @Size(min=5,max=20)
    public String description;

    @JsonProperty("price")
    @NotNull
    public Integer price;
}

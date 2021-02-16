package com.github.matthewbretten;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import com.github.matthewbretten.json.JsonPrintable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@JsonPropertyOrder({
        "customer",
        "totalPrice",
        "items",
        "dateCreated"
})
public class Basket implements JsonPrintable{
    @JsonProperty("customer")
    @Valid
    public Customer customer;

    @JsonProperty("totalPrice")
    @NotNull
    public Integer totalPrice;

    @JsonProperty("items")
    @Size(min=1, max=999)
    @Valid
    public List<Item> items = new ArrayList<Item>();

    @JsonProperty(value = "dateCreated",required = true)
    @JsonPropertyDescription("The timestamp in ISO8601 UTC format: YYYY-MM-DDThh:mm:ss.sssZ")
    @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}\\.[0-9]{3}Z")
    @Size(min=24, max=24)
    @NotNull
    public String dateCreated;
}

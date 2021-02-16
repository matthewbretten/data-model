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
        "name",
        "age",
        "countryCode"
})
public class Customer {
    @JsonProperty("name")
    @Size(min=5,max=20)
    public String name;

    @JsonProperty("age")
    @NotNull
    public Integer age;

    @JsonProperty("countryCode")
    @Size(min=2,max=2)
    public String countryCode;
}

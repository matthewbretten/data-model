package com.github.matthewbretten.json;

import com.github.matthewbretten.Basket;
import com.github.matthewbretten.Customer;
import com.github.matthewbretten.Item;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class JsonBuilderTest{

    @Test
    public void toJson(){
        Basket.BasketBuilder basketBuilder = Basket.builder();

        Customer.CustomerBuilder customerBuilder = Customer.builder();
        customerBuilder.name("Billy Boat");
        customerBuilder.age(27);
        customerBuilder.countryCode("GB");
        Customer customer = customerBuilder.build();

        Item.ItemBuilder itemBuilder = Item.builder();
        itemBuilder.basketItemId(244);
        itemBuilder.price(110);
        itemBuilder.description("Stuff");
        Item item = itemBuilder.build();

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(item);


        basketBuilder.customer(customer);
        basketBuilder.totalPrice(110);
        basketBuilder.items(items);
        Basket basket = basketBuilder.build();

        String basketJson = basket.toJson();

        assertThat(basketJson, is(equalTo("{\"customer\":{\"name\":\"Billy Boat\",\"age\":27,\"countryCode\":\"GB\"},\"totalPrice\":110,\"items\":[{\"basketItemId\":244,\"description\":\"Stuff\",\"price\":110}]}")));
    }

}
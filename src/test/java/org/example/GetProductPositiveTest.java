package org.example;

import lombok.SneakyThrows;
import org.example.DTO.Product;
import org.example.API.ProductService;
import org.example.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductPositiveTest
{
    static ProductService product;
    @BeforeAll
    public static void BeforeAll()
    {
        product = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @SneakyThrows
    @Test
    void getProductByID()
    {
        Response<Product> response = product.getProduct(20909).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getTitle(),equalTo("California Maki"));
    }
}

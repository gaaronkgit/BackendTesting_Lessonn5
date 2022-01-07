package org.example;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.example.DTO.Product;
import org.example.API.ProductService;
import org.example.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class CreateProductPositiveTest
{
    static ProductService productService;
    Product product;
    Faker faker = new Faker();
    int id;

    @BeforeAll
    public static void BeforeAll()
    {
        productService = RetrofitUtils
                .getRetrofit()
                .create(ProductService.class);
    }
    @BeforeEach
    void SetUp()
    {
        product = new Product()
                .withCategoryTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int)(Math.random()*10000));
    }

    @Test
    @SneakyThrows
    void CreateFoodProduct()
    {
        Response<Product> response =productService.createProduct(product).execute();
        id = response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

    @SneakyThrows
    @AfterEach
    void DeleteProduct()
    {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(),CoreMatchers.is(true));
    }

}


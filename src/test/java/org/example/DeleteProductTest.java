package org.example;

import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.example.API.ProductService;
import org.example.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteProductTest
{
    static ProductService productService;

    int id = 20909;

    @BeforeAll
    public static void BeforeAll()
    {
        productService = RetrofitUtils
                .getRetrofit()
                .create(ProductService.class);
    }
    @SneakyThrows
    @Test
    void DeleteProduct()
    {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }
}

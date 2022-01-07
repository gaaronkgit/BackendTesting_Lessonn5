package org.example;

import lombok.SneakyThrows;
import org.example.DTO.GetCategoryResponse;
import org.example.API.CategoryService;
import org.example.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GetCategoryPositiveTest
{
    static CategoryService categoryService;

    @BeforeAll
    static void BeforeAll()
    {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);
    }

    @SneakyThrows
    @Test
    void getFoodCategory()
    {
        Response<GetCategoryResponse> response = categoryService.getCategory(1).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(),equalTo(1));
    }
}

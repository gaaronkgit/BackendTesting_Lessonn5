package org.example.API;

import okhttp3.ResponseBody;
import org.example.DTO.GetCategoryResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoryService
{
    @GET("categories/{id}")
    Call<GetCategoryResponse> getCategory (@Path("id") int id);

    @GET("categories/notresult/{id}")
    Call<ResponseBody> getCategoryNoRes (@Path("id") int id);
}

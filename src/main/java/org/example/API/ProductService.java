package org.example.API;

import okhttp3.ResponseBody;
import org.example.DTO.Product;
import retrofit2.Call;
import retrofit2.http.*;

public interface ProductService
{
    @POST("products")
    Call<Product> createProduct (@Body Product createProductRequest);

    @GET("products/{id}")
    Call<Product> getProduct(@Path("id") int id);

    @PUT("products")
    Call<Product> modifyProduct (@Body String product);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct (@Path("id") int id);
}

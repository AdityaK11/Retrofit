package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface apiInterface {

    String Base_url = "http://dummy.restapiexample.com/api/v1/";

    @GET("employees")
    Call<List<Employee>> getEmployees();
}

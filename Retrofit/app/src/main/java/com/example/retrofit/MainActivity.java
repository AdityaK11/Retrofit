package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.rView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiInterface.Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface api = retrofit.create(apiInterface.class);

        Call<List<Employee>> call = api.getEmployees();

        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                List<Employee> Employees = response.body();
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.layout_list_item,Employees);
                for(Employee e: Employees){
                    Log.i("id",e.getId());
                    Log.i("name",e.getName());
                    Log.i("age",e.getAge());
                    Log.i("salary",e.getSalary());
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}

package com.example.countrycodes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetDataService service = RetrofitClient.getRetrofitInstance().create(GetDataService.class);
        Call<List<Country>> call = service.getCountrys();
        call.enqueue(new Callback<List<Country>>() {

            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                generateDataList(response.body());  
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d("retrofit1", t.toString());
                
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
            
            
        });
    }

    private void generateDataList(List<Country> body) {
        recyclerView = findViewById(R.id.recycler);
        adapter = new CustomAdapter(this,body);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.child_edu:
                Intent i = new Intent(MainActivity.this, childEducation.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



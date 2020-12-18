package com.example.webinar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static final String key = "a2fcc3d9e6694211ba09c48fb97385e3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.Recycle);

        layoutManager=new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        getdata();




    }

    public void getdata()
    {
        Call<PostList> listCall=api.getPostservices().getpostlist("in",key);
        listCall.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {


                PostList list=response.body();
                recyclerView.setAdapter(new adapter(list.getArticles(),MainActivity.this));
                Toast.makeText(MainActivity.this, "No error", Toast.LENGTH_SHORT).show();


            }
            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "errorr kuch gadhbadh", Toast.LENGTH_SHORT).show();

            }
        });
    }
    //
}
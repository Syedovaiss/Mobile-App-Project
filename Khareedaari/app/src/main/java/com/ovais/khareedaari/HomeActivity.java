package com.ovais.khareedaari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<Listitem> listItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.myRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        listItems =new ArrayList<>();
        loadRecycleViewdata();


    }

    private void loadRecycleViewdata() {
        final ProgressDialog progressDialog =new ProgressDialog(this) ;
        progressDialog.setMessage("Loadinng...");
        progressDialog.show();
        String url="http://10.0.2.2:5000/get_categories";
        StringRequest request = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray =new JSONArray(response) ;
                            for(int i = 0; i<jsonArray.length(); i++)
                            {
                                JSONObject o =jsonArray.getJSONObject(i);
                                Listitem item = new Listitem(
                                        o.getString("category_image"),
                                        o.getString("category_name")



                                );
                                listItems.add(item);
                                progressDialog.dismiss();


                            }
                            recyclerView.setAdapter(adapter);
                            adapter =new RecyclerViewAdapter(listItems, getApplicationContext());
                            recyclerView.setAdapter(adapter);
                           // adapter.setOnClickListener(HomeActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();


            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this );
        requestQueue.add(request);


    }
}



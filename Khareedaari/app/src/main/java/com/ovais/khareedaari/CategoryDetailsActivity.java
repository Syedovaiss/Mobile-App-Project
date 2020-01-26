package com.ovais.khareedaari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.ovais.khareedaari.RecyclerViewAdapter.EXTRA_NAME;
import static com.ovais.khareedaari.RecyclerViewAdapter.EXTRA_URL;

public class CategoryDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<TShirts> tShirts;
    private List<Belts> belts;
    private List<Wallets> wallets;
    private List<Shoes> shoes;


    private TextView category_name;
    private ImageView category_image;
    // private Bundle extras;
    Listitem listitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  extras=getIntent().getExtras();
        setContentView(R.layout.activity_category_details_activity);

        recyclerView = findViewById(R.id.myRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        tShirts = new ArrayList<>();
        belts = new ArrayList<>();
        wallets = new ArrayList<>();
        shoes = new ArrayList<>();

        Intent intent = getIntent();
            String category_image_intent = intent.getStringExtra(EXTRA_URL);
            String category_name_intent = intent.getStringExtra(EXTRA_NAME);



            category_name = findViewById(R.id.text_view_category_detail);
            category_image = findViewById(R.id.image_view_detail);


            if (intent != null ) {
                Picasso.get()
                        .load(category_image_intent)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(category_image);
                if (category_name_intent=="Shoes"){

                    ShoesData();

                }
                else if (category_name_intent==" T-Shirt"){TShirtsData();}
                else if (category_name_intent==" Belt"){BeltData();}
                else if (category_name_intent==" Wallet"){WalletData();}
                else{
                    TShirtsData();
                    BeltData();
                    WalletData();
                    ShoesData();

                }
//}
            }

//        Intent intent = getIntent();
//        String category_image_intent = intent.getStringExtra(EXTRA_URL);
//        String category_name_intent = intent.getStringExtra(EXTRA_NAME);
//        Log.i("Name",EXTRA_NAME);
//        Log.i("intent",category_name_intent);





      // TShirtsData();
    }


    private void TShirtsData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        String url = "http://10.0.2.2:5000/get_tshirt";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject o = jsonArray.getJSONObject(i);
                                TShirts shirt = new TShirts(
                                        o.getString("picture"),
                                        o.getString("pName"),
                                        o.getString("price"),
                                        o.getString("description")


                                );
                                tShirts.add(shirt);
                                progressDialog.dismiss();


                            }
                            recyclerView.setAdapter(adapter);
                            adapter = new TShirtAdapter(tShirts, getApplicationContext());
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

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }


    private void BeltData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loadinng...");
        progressDialog.show();
        String url = "http://10.0.2.2:5000/get_belt";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject o = jsonArray.getJSONObject(i);
                                Belts belt = new Belts(
                                        o.getString("picture"),
                                        o.getString("pName"),
                                        o.getString("price"),
                                        o.getString("description")


                                );
                                belts.add(belt);
                                progressDialog.dismiss();


                            }
                            recyclerView.setAdapter(adapter);
                            adapter = new BeltAdapter(belts, getApplicationContext());
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

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void WalletData() {


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loadinng...");
        progressDialog.show();
        String url = "http://10.0.2.2:5000/get_wallet";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject o = jsonArray.getJSONObject(i);
                                Wallets wallet = new Wallets(
                                        o.getString("picture"),
                                        o.getString("pName"),
                                        o.getString("price"),
                                        o.getString("description")


                                );
                                wallets.add(wallet);
                                progressDialog.dismiss();


                            }
                            recyclerView.setAdapter(adapter);
                            adapter = new WalletAdapter(wallets, getApplicationContext());
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

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }

    private void ShoesData() {



        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loadinng...");
        progressDialog.show();
        String url = "http://10.0.2.2:5000/get_shoes";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject o = jsonArray.getJSONObject(i);
                                Shoes shoe = new Shoes(
                                        o.getString("picture"),
                                        o.getString("pName"),
                                        o.getString("price"),
                                        o.getString("description")


                                );
                                shoes.add(shoe);
                                progressDialog.dismiss();


                            }
                            recyclerView.setAdapter(adapter);
                            adapter = new ShoesAdapter(shoes, getApplicationContext());
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

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}



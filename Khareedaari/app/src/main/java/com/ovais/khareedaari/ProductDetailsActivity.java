package com.ovais.khareedaari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.ovais.khareedaari.BeltAdapter.EXTRA_BELT_DESCRIPTION;
import static com.ovais.khareedaari.BeltAdapter.EXTRA_BELT_PRICE;
import static com.ovais.khareedaari.BeltAdapter.EXTRA_NAME_BELT;
import static com.ovais.khareedaari.BeltAdapter.EXTRA_URL_BELT;
import static com.ovais.khareedaari.RecyclerViewAdapter.EXTRA_NAME;
import static com.ovais.khareedaari.RecyclerViewAdapter.EXTRA_URL;
import static com.ovais.khareedaari.ShoesAdapter.EXTRA_NAME_SHOE;
import static com.ovais.khareedaari.ShoesAdapter.EXTRA_SHOE_DESCRIPTION;
import static com.ovais.khareedaari.ShoesAdapter.EXTRA_SHOE_PRICE;
import static com.ovais.khareedaari.ShoesAdapter.EXTRA_URL_SHOE;
import static com.ovais.khareedaari.TShirtAdapter.EXTRA_NAME_SHIRT;
import static com.ovais.khareedaari.TShirtAdapter.EXTRA_SHIRT_DESCRIPTION;
import static com.ovais.khareedaari.TShirtAdapter.EXTRA_SHIRT_PRICE;
import static com.ovais.khareedaari.TShirtAdapter.EXTRA_URL_SHIRT;
import static com.ovais.khareedaari.WalletAdapter.EXTRA_NAME_WALLET;
import static com.ovais.khareedaari.WalletAdapter.EXTRA_URL_WALLET;
import static com.ovais.khareedaari.WalletAdapter.EXTRA_WALLET_DESCRIPTION;
import static com.ovais.khareedaari.WalletAdapter.EXTRA_WALLET_PRICE;

public class ProductDetailsActivity extends AppCompatActivity{
        private RecyclerView recyclerView;
        private RecyclerView.LayoutManager layoutManager;
        private RecyclerView.Adapter adapter;
        private List<TShirts> tShirts;
        private List<Belts> belts;
        private List<Wallets> wallets;
        private List<Shoes> shoes;


        private TextView name,price,description;
        private ImageView image;
        // private Bundle extras;



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
            String shirt_image_intent = intent.getStringExtra(EXTRA_URL_SHIRT);
            String shirt_name_intent = intent.getStringExtra(EXTRA_NAME_SHIRT);
            String shirt_price=intent.getStringExtra(EXTRA_SHIRT_PRICE);
            String shirt_description=intent.getStringExtra(EXTRA_SHIRT_DESCRIPTION);


            String shoes_image_intent = intent.getStringExtra(EXTRA_URL_SHOE);
            String shoes_name_intent = intent.getStringExtra(EXTRA_NAME_SHOE);
            String shoe_price=intent.getStringExtra(EXTRA_SHOE_PRICE);
            String shoe_description=intent.getStringExtra(EXTRA_SHOE_DESCRIPTION);

            String belt_image_intent = intent.getStringExtra(EXTRA_URL_BELT);
            String belt_name_intent = intent.getStringExtra(EXTRA_NAME_BELT);
            String belt_price=intent.getStringExtra(EXTRA_BELT_PRICE);
            String belt_description=intent.getStringExtra(EXTRA_BELT_DESCRIPTION);

            String wallet_image_intent = intent.getStringExtra(EXTRA_URL_WALLET);
            String wallet_name_intent = intent.getStringExtra(EXTRA_NAME_WALLET);
            String wallet_price=intent.getStringExtra(EXTRA_WALLET_PRICE);
            String wallet_description=intent.getStringExtra(EXTRA_WALLET_DESCRIPTION);



            name = findViewById(R.id.text_view_category_detail);
            image = findViewById(R.id.image_view_detail);
            price=findViewById(R.id.price);
            description=findViewById(R.id.description);
            if (shirt_name_intent=="T-Shirt"){
                name.setText(shirt_name_intent);
                Picasso.get()
                        .load(shirt_image_intent)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(image);


            }
            if (belt_name_intent==" belt"){
                name.setText(belt_name_intent);
                Picasso.get()
                        .load(belt_image_intent)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(image);
//                price.setText(belt_price);
//                description.setText(belt_description);


            }

            if (shoes_name_intent==" Shoes"){
                name.setText(shoes_image_intent);
                Picasso.get()
                        .load(shoes_image_intent)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(image);
//                price.setText(shoe_price);
//                description.setText(shoe_description);


            }
            if (wallet_name_intent==" Wallet"){
                name.setText(wallet_name_intent);
                Picasso.get()
                        .load(wallet_image_intent)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(image);
//                price.setText(wallet_price);
//                description.setText(wallet_description);


            }
            else{
                name.setText(shirt_name_intent);
                Picasso.get()
                        .load(shirt_image_intent)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(image);
//                price.setText(shirt_price);
//                description.setText(shirt_description);







            }


//            if (intent != null ) {
//                Picasso.get()
//                        .load(category_image_intent)
//                        .placeholder(R.drawable.ic_launcher_background)
//                        .error(R.drawable.ic_launcher_background)
//                        .into(category_image);
//
//            }

        String category_image_intent = intent.getStringExtra(EXTRA_URL);
        String category_name_intent = intent.getStringExtra(EXTRA_NAME);






            // TShirtsData();
        }}
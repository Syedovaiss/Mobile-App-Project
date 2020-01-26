package com.ovais.khareedaari;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class WalletAdapter extends RecyclerView.Adapter <WalletAdapter.MatchViewHolder> {
    private List<Wallets> wallets;
    private Context context;
    public static final String EXTRA_URL_WALLET="imageUrl";
    public static final String EXTRA_NAME_WALLET="category_name";
    public static final String EXTRA_WALLET_PRICE="price";
    public static final String EXTRA_WALLET_DESCRIPTION="description";
    //private static OnItemClickListener myListener;

//    public interface OnItemClickListener{
//        void onItemClick(int postion);
//    }
//    public void setOnItemClickListener(OnItemClickListener listener){
//    myListener=listener;
//
//
//    }



    public WalletAdapter (List<Wallets> wallets, Context context )
    {
        this.wallets = wallets;
        this.context =context;
    }
    @NonNull
    @Override
    public WalletAdapter.MatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_cards,viewGroup, false );
        WalletAdapter.MatchViewHolder matchViewHolder =new WalletAdapter.MatchViewHolder(view);
        return matchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WalletAdapter.MatchViewHolder viewHolder, int i) {
        Wallets walls =wallets.get(i);
        ImageView imageView =viewHolder.imageView;
        String url=walls.getImage();
        Log.i("URL: ",url);
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.shirt)
                .error(R.drawable.shirt)
                .into(imageView);
        viewHolder.textView.setText(walls.getTitle());
        viewHolder.priceText.setText(walls.getPrice());





    }

    @Override
    public int getItemCount() {
        return wallets.size();
    }
    public class MatchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView ;
        TextView textView,priceText;

        public MatchViewHolder(@NonNull View itemView)   {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.pic);
            textView = itemView.findViewById(R.id.title);
            priceText=itemView.findViewById(R.id.price);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (myListener!=null){
//                        int position=getAdapterPosition();
//                        if (position!=RecyclerView.NO_POSITION){
//                            myListener.onItemClick(position);
//                        }
//
//
//
//                    }
//                }
//            });


        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            Wallets my_wallet=wallets.get(position);

            Intent intent=new Intent(context, ProductDetailsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(EXTRA_URL_WALLET,my_wallet.getImage());
            intent.putExtra(EXTRA_NAME_WALLET,my_wallet.getTitle());
            intent.putExtra(EXTRA_WALLET_PRICE,my_wallet.getPrice());
            intent.putExtra(EXTRA_WALLET_DESCRIPTION,my_wallet.getDescription());


//            Log.i("Image URL",listitem.getImage());
//            intent.putExtra("resId",listitem.getImage());
//            //intent.putExtra("resId",listitem.getImage());
//            intent.putExtra("title",listitem.getTitle());
            context.startActivity(intent);

            //Toast.makeText(context,listitem.getTitle(),Toast.LENGTH_LONG).show();



        }
    }
}

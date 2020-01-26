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

public class TShirtAdapter extends RecyclerView.Adapter <TShirtAdapter.MatchViewHolder> {
    private List<TShirts> tShirts;
    private Context context;
    public static final String EXTRA_URL_SHIRT="imageUrl";
    public static final String EXTRA_NAME_SHIRT="category_name";
    public static final String EXTRA_SHIRT_PRICE="price";
    public static final String EXTRA_SHIRT_DESCRIPTION="description";
    //private static OnItemClickListener myListener;

//    public interface OnItemClickListener{
//        void onItemClick(int postion);
//    }
//    public void setOnItemClickListener(OnItemClickListener listener){
//    myListener=listener;
//
//
//    }



    public TShirtAdapter (List<TShirts> tShirts, Context context )
    {
        this.tShirts = tShirts;
        this.context =context;
    }
    @NonNull
    @Override
    public TShirtAdapter.MatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_cards,viewGroup, false );
        TShirtAdapter.MatchViewHolder matchViewHolder =new TShirtAdapter.MatchViewHolder(view);
        return matchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TShirtAdapter.MatchViewHolder viewHolder, int i) {
        TShirts tees =tShirts.get(i);
        ImageView imageView =viewHolder.imageView;
        String url=tees.getImage();
        Log.i("URL: ",url);
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.shirt)
                .error(R.drawable.shirt)
                .into(imageView);
        viewHolder.textView.setText(tees.getTitle());
        viewHolder.priceText.setText(tees.getPrice());





    }

    @Override
    public int getItemCount() {
        return tShirts.size();
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
            TShirts tee_shirt=tShirts.get(position);

            Intent intent=new Intent(context, ProductDetailsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(EXTRA_URL_SHIRT,tee_shirt.getImage());
            intent.putExtra(EXTRA_NAME_SHIRT,tee_shirt.getTitle());
            intent.putExtra(EXTRA_SHIRT_PRICE,tee_shirt.getPrice());
            intent.putExtra(EXTRA_SHIRT_DESCRIPTION,tee_shirt.getDescription());


//            Log.i("Image URL",listitem.getImage());
//            intent.putExtra("resId",listitem.getImage());
//            //intent.putExtra("resId",listitem.getImage());
//            intent.putExtra("title",listitem.getTitle());
            context.startActivity(intent);

            //Toast.makeText(context,listitem.getTitle(),Toast.LENGTH_LONG).show();



        }
    }
}

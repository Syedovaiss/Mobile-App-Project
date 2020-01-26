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

public class BeltAdapter extends RecyclerView.Adapter <BeltAdapter.MatchViewHolder> {
    private List<Belts> belts;
    private Context context;
    public static final String EXTRA_URL_BELT="imageUrl";
    public static final String EXTRA_NAME_BELT="category_name";
    public static final String EXTRA_BELT_PRICE="price";
    public static final String EXTRA_BELT_DESCRIPTION="description";
    //private static OnItemClickListener myListener;

//    public interface OnItemClickListener{
//        void onItemClick(int postion);
//    }
//    public void setOnItemClickListener(OnItemClickListener listener){
//    myListener=listener;
//
//
//    }



    public BeltAdapter (List<Belts> belts, Context context )
    {
        this.belts = belts;
        this.context =context;
    }
    @NonNull
    @Override
    public BeltAdapter.MatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_cards,viewGroup, false );
        BeltAdapter.MatchViewHolder matchViewHolder =new BeltAdapter.MatchViewHolder(view);
        return matchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BeltAdapter.MatchViewHolder viewHolder, int i) {
        Belts beltss =belts.get(i);
        ImageView imageView =viewHolder.imageView;
        String url=beltss.getImage();
        Log.i("URL: ",url);
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.shirt)
                .error(R.drawable.shirt)
                .into(imageView);
        viewHolder.textView.setText(beltss.getTitle());
        viewHolder.priceText.setText(beltss.getPrice());





    }

    @Override
    public int getItemCount() {
        return belts.size();
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
            Belts my_belt=belts.get(position);

            Intent intent=new Intent(context, ProductDetailsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(EXTRA_URL_BELT,my_belt.getImage());
            intent.putExtra(EXTRA_NAME_BELT,my_belt.getTitle());
            intent.putExtra(EXTRA_BELT_PRICE,my_belt.getPrice());
            intent.putExtra(EXTRA_BELT_DESCRIPTION,my_belt.getDescription());


//            Log.i("Image URL",listitem.getImage());
//            intent.putExtra("resId",listitem.getImage());
//            //intent.putExtra("resId",listitem.getImage());
//            intent.putExtra("title",listitem.getTitle());
            context.startActivity(intent);

            //Toast.makeText(context,listitem.getTitle(),Toast.LENGTH_LONG).show();



        }
    }
}

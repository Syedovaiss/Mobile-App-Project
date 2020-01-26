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

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.MatchViewHolder> {
    private List<Listitem> listItems;
    private Context context;
    public static final String EXTRA_URL="imageUrl";
    public static final String EXTRA_NAME="category_name";
    //private static OnItemClickListener myListener;

//    public interface OnItemClickListener{
//        void onItemClick(int postion);
//    }
//    public void setOnItemClickListener(OnItemClickListener listener){
//    myListener=listener;
//
//
//    }



    public RecyclerViewAdapter (List<Listitem> listItems, Context context )
    {
        this.listItems = listItems;
        this.context =context;
    }
    @NonNull
    @Override
    public MatchViewHolder  onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items,viewGroup, false );
        MatchViewHolder matchViewHolder =new MatchViewHolder(view);
        return matchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder  viewHolder, int i) {
        Listitem listItem =listItems.get(i);
        ImageView imageView =viewHolder.imageView;
        String url=listItem.getImage();
        Log.i("URL: ",url);
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.shirt)
                .error(R.drawable.shirt)
                .into(imageView);
        viewHolder.textView.setText(listItem.getTitle());





    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
    public class MatchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView ;
        TextView textView;

        public MatchViewHolder(@NonNull View itemView)   {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.pic);
            textView = itemView.findViewById(R.id.title);
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
            Listitem listitem=listItems.get(position);

            Intent intent=new Intent(context, CategoryDetailsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(EXTRA_URL,listitem.getImage());
            intent.putExtra(EXTRA_NAME,listitem.getTitle());


//            Log.i("Image URL",listitem.getImage());
//            intent.putExtra("resId",listitem.getImage());
//            //intent.putExtra("resId",listitem.getImage());
//            intent.putExtra("title",listitem.getTitle());
            context.startActivity(intent);

            //Toast.makeText(context,listitem.getTitle(),Toast.LENGTH_LONG).show();



        }
    }
}
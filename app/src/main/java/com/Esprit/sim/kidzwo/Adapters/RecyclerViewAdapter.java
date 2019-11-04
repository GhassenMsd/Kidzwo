package com.Esprit.sim.kidzwo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Esprit.sim.kidzwo.Activities.BookPdf;
import com.Esprit.sim.kidzwo.Entities.CustomVolleyRequest;
import com.Esprit.sim.kidzwo.R;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.Esprit.sim.kidzwo.Entities.Book;
import com.Esprit.sim.kidzwo.Entities.Connexion;

import java.util.List;

/**
 * Created by Aws on 28/01/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Book> mData ;
    NetworkImageView previewImage;
    ImageLoader imageLoader;


    public RecyclerViewAdapter(Context mContext, List<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.book_prototype,parent,false);

        previewImage = view.findViewById(R.id.book_img_id);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        imageLoader = CustomVolleyRequest.getInstance(mContext)
                .getImageLoader();
        imageLoader.get(Connexion.urlimage+mData.get(position).getImage(), ImageLoader.getImageListener(previewImage
                ,0,android.R.drawable
                        .ic_dialog_alert));
        previewImage.setImageUrl(Connexion.urlimage+mData.get(position).getImage(), imageLoader);

        holder.tv_book_title.setText(mData.get(position).getTitre());
        //holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, BookPdf.class);
                intent.putExtra("res",mData.get(position).getRes());
                mContext.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.book_title_id) ;
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}

package com.Esprit.sim.kidzwo.Adapters;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Esprit.sim.kidzwo.Entities.CustomVolleyRequest;
import com.Esprit.sim.kidzwo.Fragments.Learn;
import com.Esprit.sim.kidzwo.R;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.Esprit.sim.kidzwo.Entities.Connexion;
import com.Esprit.sim.kidzwo.Entities.Item;

import java.util.List;

public class RecycleViewItemAdapter  extends RecyclerView.Adapter<RecycleViewItemAdapter.MyViewHolder> {
    private Context mContext ;
    private List<Item> mData ;
    NetworkImageView previewImage;
    String urlimage;
    ImageLoader imageLoader;
    private TextToSpeech mTTS,mTTsF,mTTsG;
    Learn learn = new Learn();



    public RecycleViewItemAdapter(Context mContext, List<Item> mData, TextToSpeech mTTSA, TextToSpeech mTTSF, TextToSpeech mTTsG) {
        this.mContext = mContext;
        this.mData = mData;
        this.mTTS = mTTSA;
        this.mTTsF=mTTSF;
        this.mTTsG=mTTsG;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_prototype,parent,false);
        previewImage = view.findViewById(R.id.item_img_id);


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

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //learn.MyCustomAlertDialog(position,mData);
                mTTS.speak(mData.get(position).getTitre(), TextToSpeech.QUEUE_FLUSH, null);

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

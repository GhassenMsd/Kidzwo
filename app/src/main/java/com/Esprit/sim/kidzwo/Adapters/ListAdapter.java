package com.Esprit.sim.kidzwo.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


import com.Esprit.sim.kidzwo.Entities.User;
import com.Esprit.sim.kidzwo.Entities.Userr;
import com.Esprit.sim.kidzwo.R;
import com.ramotion.foldingcell.FoldingCell;


public class ListAdapter extends BaseAdapter {
    Context context ;
    private List<Userr> users ;
    private LayoutInflater inflater;


    public ListAdapter(Context context, List<Userr> users) {
        this.context = context;
        this.users = users;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {

        Log.e("test get viiieeeww", users.toString());

        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.user_prototype,null);
        final FoldingCell foldingcell = view.findViewById(R.id.folding_cell);

        //FrameLayout proto = (FrameLayout) view.findViewById(R.id.prototype);
        TextView login = (TextView) view.findViewById(R.id.Login);
        TextView scoreM = (TextView) view.findViewById(R.id.math);
        TextView scoreF = (TextView) view.findViewById(R.id.french);
        TextView scoreAn = (TextView) view.findViewById(R.id.english);
        TextView scoreQ = (TextView) view.findViewById(R.id.qi);
        TextView scoreA = (TextView) view.findViewById(R.id.alphabet);
        TextView scoreAU = (TextView) view.findViewById(R.id.audio);

        login.setText(String.valueOf(users.get(i).getLogin()));
        scoreM.setText("Math: "+String.valueOf(users.get(i).getScoremath()));
        scoreF.setText("French: "+String.valueOf(users.get(i).getScorefrench()));
        scoreAn.setText("English: "+String.valueOf(users.get(i).getScoreenglish()));
        scoreQ.setText("Qi: "+String.valueOf(users.get(i).getScoreqi()));
        scoreA.setText("Alphabet: "+String.valueOf(users.get(i).getScoreal()));
        scoreAU.setText("Audio: "+String.valueOf(users.get(i).getScoreaudio()));

        if(users.get(i).getLogin().equals(User.login))
        {
            //proto.setBackgroundColor(Color.YELLOW);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foldingcell.toggle(false);
            }
        });
        return view;
    }
}

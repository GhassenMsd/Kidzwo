package com.Esprit.sim.kidzwo.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.Esprit.sim.kidzwo.Activities.AudioNiveau;
import com.Esprit.sim.kidzwo.Activities.English;
import com.Esprit.sim.kidzwo.Activities.French;
import com.Esprit.sim.kidzwo.Activities.Math;
import com.Esprit.sim.kidzwo.Activities.Memory;
import com.Esprit.sim.kidzwo.Activities.QiNiveau;
import com.Esprit.sim.kidzwo.R;


public class Grid extends Fragment {
    public static final int REQUEST_CODE = 10 ;
    Button math,french,english,qi,audio,al;
    TextView Mathh,Frenchh,Qii,Englishh;

    public Grid() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid, container, false);


        Mathh = view.findViewById(R.id.Mathh);
        Frenchh= view.findViewById(R.id.Frenchh);
        Qii= view.findViewById(R.id.Qii);
        Englishh = view.findViewById(R.id.Englishh);



        math = view.findViewById(R.id.math);
        french = view.findViewById(R.id.french);
        qi = view.findViewById(R.id.qi);
        english = view.findViewById(R.id.english);
        audio = view.findViewById(R.id.audio);
        al = view.findViewById(R.id.al);



        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Math.class);
                intent.putExtra("cat","Math");
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent french = new Intent(getActivity(), French.class);
                french.putExtra("cat","French");
                startActivityForResult(french,REQUEST_CODE);
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent english = new Intent(getActivity(), English.class);
                english.putExtra("cat","English");
                startActivityForResult(english,REQUEST_CODE);

            }
        });
        qi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qi = new Intent(getActivity(), QiNiveau.class);
                qi.putExtra("cat","Qi");
                startActivityForResult(qi,REQUEST_CODE);
            }
        });
        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent audio = new Intent(getActivity(), AudioNiveau.class);
                audio.putExtra("cat","Audio");
                startActivityForResult(audio,REQUEST_CODE);
            }
        });
        al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent memory = new Intent(getActivity(), Memory.class);
                memory.putExtra("cat","Alphabet");
                startActivityForResult(memory,REQUEST_CODE);
            }
        });

        return view;
    }

}

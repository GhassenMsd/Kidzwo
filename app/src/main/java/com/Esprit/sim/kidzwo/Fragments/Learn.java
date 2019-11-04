package com.Esprit.sim.kidzwo.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.Esprit.sim.kidzwo.Activities.CameraToText;
import com.Esprit.sim.kidzwo.R;
import com.Esprit.sim.kidzwo.Adapters.RecycleViewItemAdapter;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.Esprit.sim.kidzwo.Entities.Connexion;
import com.Esprit.sim.kidzwo.Entities.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


public class Learn extends Fragment {
    String url;
    RequestQueue queue ;
    EditText texts;
    Button buttons,showme;
    List<Item> lstitem = new ArrayList<Item>();
    RecyclerView myrv;
    private TextToSpeech mTTSA,mTTSF,mTTSG;

    public Learn() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learn, container, false);
        texts = view.findViewById(R.id.textS);
        buttons = view.findViewById(R.id.buttonS);
        showme = view.findViewById(R.id.showText);




        mTTSA = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTSA.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        mTTSF = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTSF.setLanguage(Locale.FRENCH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        mTTSG = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTSG.setLanguage(Locale.GERMAN);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTTSA.speak(texts.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        showme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CameraToText.class);
                startActivity(intent);
            }
        });

        myrv = (RecyclerView) view.findViewById(R.id.recyclerview_id_item);

        queue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
        url = Connexion.url+"itemall/";
        StringRequest getData = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    if (obj.getInt("success") == 1) {
                        JSONArray row = new JSONArray(obj.getString("result"));
                        for ( int j=0 ; j < row.length() ; j++) {
                            JSONObject use = row.getJSONObject(j);
                            Item item = new Item(use.getInt("id"),
                                    use.getString("titre"),
                                    use.getString("image"),
                                    use.getString("titrefrench"),
                                    use.getString("titregerman"));
                            lstitem.add(item);
                        }


                        Log.e("test list itemm", lstitem.toString());
                        RecycleViewItemAdapter myAdapter = new RecycleViewItemAdapter(getActivity(),lstitem,mTTSA,mTTSF,mTTSG);
                        myrv.setLayoutManager(new GridLayoutManager(getActivity(),3));
                        myrv.setAdapter(myAdapter);
                    }

                } catch (JSONException e) {
                    Log.e("JSONExeption", e.getMessage());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorResponse", error.getMessage());
            }
        });

        queue.add(getData);
        //RecycleViewItemAdapter myAdapter = new RecycleViewItemAdapter(getActivity(),lstitem);
        //myrv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        //myrv.setAdapter(myAdapter);
        return view;


    }
    public void MyCustomAlertDialog(final int i, final List<Item> mdata){

        Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(true);

        View view  = getActivity().getLayoutInflater().inflate(R.layout.custom_dialog_langue, null);
        dialog.setContentView(view);

        Button french = (Button)dialog.findViewById(R.id.frenchL);
        Button English = (Button)dialog.findViewById(R.id.EnglishL);
        Button German = (Button)dialog.findViewById(R.id.GermanL);

        french.setEnabled(true);
        English.setEnabled(true);
        German.setEnabled(true);

        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTTSF.speak(mdata.get(i).getTitrefrench(), TextToSpeech.QUEUE_FLUSH, null);
                //Toast.makeText(getApplicationContext(), "Hello, I'm Custom Alert Dialog", Toast.LENGTH_LONG).show();
            }
        });
        English.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTTSF.speak(mdata.get(i).getTitre(), TextToSpeech.QUEUE_FLUSH, null);
                //MyDialog.cancel();
            }
        });
        German.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTTSF.speak(mdata.get(i).getTitregerman(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        dialog.show();
    }



}

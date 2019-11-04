package com.Esprit.sim.kidzwo.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Esprit.sim.kidzwo.R;
import com.Esprit.sim.kidzwo.Adapters.RecyclerViewAdapter;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.Esprit.sim.kidzwo.Entities.Book;
import com.Esprit.sim.kidzwo.Entities.Connexion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Books extends Fragment {
    String url;
    RequestQueue queue ;
    List<Book> lstBook = new ArrayList<Book>();
    RecyclerView myrv;

    public Books() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_books, container, false);

       myrv = (RecyclerView) view.findViewById(R.id.recyclerview_id);

        queue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
        url = Connexion.url+"bookall/";
        StringRequest getData = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    if (obj.getInt("success") == 1) {
                        JSONArray row = new JSONArray(obj.getString("result"));
                        for ( int j=0 ; j < row.length() ; j++) {
                            JSONObject use = row.getJSONObject(j);
                            Book book = new Book(use.getInt("id"),
                                    use.getString("titre"),
                                    use.getString("image"),
                                    use.getString("res"));
                            lstBook.add(book);
                        }


                        Log.e("test list bookks", lstBook.toString());
                        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(),lstBook);
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
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(),lstBook);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        myrv.setAdapter(myAdapter);
        return view;


    }

}

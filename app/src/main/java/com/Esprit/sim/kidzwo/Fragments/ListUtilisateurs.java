package com.Esprit.sim.kidzwo.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.Esprit.sim.kidzwo.Adapters.ListAdapter;
import com.Esprit.sim.kidzwo.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.Esprit.sim.kidzwo.Entities.Connexion;
import com.Esprit.sim.kidzwo.Entities.Userr;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ListUtilisateurs extends Fragment {

    String url;
    RequestQueue queue ;
    ListView listViewU;

    List<Userr> listuser = new ArrayList<Userr>();


    public ListUtilisateurs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_utilisateurs, container, false);
        listViewU = (ListView) view.findViewById(R.id.listutili);
        queue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
        url = Connexion.url+"userall/";
        StringRequest getData = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    if (obj.getInt("success") == 1) {
                        JSONArray row = new JSONArray(obj.getString("result"));
                        for ( int j=0 ; j < row.length() ; j++) {
                            JSONObject use = row.getJSONObject(j);
                            Userr userr = new Userr(use.getInt("id"),
                                    use.getString("login"),
                                    use.getString("nom"),
                                    use.getString("prenom"),
                                    use.getString("password"),
                                    use.getString("email"),
                                    use.getInt("score"),
                                    use.getInt("scoremath"),
                                    use.getInt("scoreenglish"),
                                    use.getInt("scorefrench"),
                                    use.getInt("scoreqi"),
                                    use.getInt("scoreaudio"),
                                    use.getInt("scoreal"));
                            listuser.add(userr);
                        }
                        Log.e("test list utilisateurs", listuser.toString());
                        ListAdapter adapter = new ListAdapter(getActivity(), listuser);
                        listViewU.setAdapter(adapter);
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
        Log.e("test list utilisateurs", listuser.toString());
        listViewU = (ListView) view.findViewById(R.id.listutili);
        ListAdapter adapter = new ListAdapter(getActivity(), listuser);
        listViewU.setAdapter(adapter);

        return view;
    }

}

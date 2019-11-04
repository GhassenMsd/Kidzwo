package com.Esprit.sim.kidzwo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Esprit.sim.kidzwo.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.Esprit.sim.kidzwo.Entities.Connexion;
import com.Esprit.sim.kidzwo.Entities.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 10 ;

    String url;
    RequestQueue queue ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnSignup=findViewById(R.id.btnSignup);
        Button Login= findViewById(R.id.Loginnnnn);
        final EditText login= findViewById(R.id.Login);
        final EditText psw= findViewById(R.id.Psw);
        queue = Volley.newRequestQueue(this);



        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });




        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = Connexion.url+"loginx/";
                url += login.getText() + "/" + psw.getText();
                StringRequest getData = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            if (obj.getInt("success") == 1) {
                                JSONArray row = new JSONArray(obj.getString("result"));
                                Intent accueil = new Intent(LoginActivity.this, MainActivity.class);
                                JSONObject use = row.getJSONObject(0);
                                User.id = use.getInt("id");
                                User.login = use.getString("login");
                                User.nom = use.getString("nom");
                                User.prenom =  use.getString("prenom");
                                User.mdp = use.getString("password");
                                User.mail = use.getString("email");
                                User.score = use.getInt("score");
                                User.scoremath = use.getInt("scoremath");
                                User.scoreenglish = use.getInt("scoreenglish");
                                User.scorefrench = use.getInt("scorefrench");
                                User.scoreqi = use.getInt("scoreqi");
                                User.scoreal = use.getInt("scoreal");
                                User.scoreaudio = use.getInt("scoreaudio");
                                User.photo = use.getString("photo");

                                startActivity(accueil);
                            } else
                                Toast.makeText(getApplicationContext(), "Invalid password or login", Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            Log.e("JSONExeption", e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("ErrorResponse", "aaaaa"+error.getMessage());
                    }
                });
                queue.add(getData);

            }
        });
    }
}
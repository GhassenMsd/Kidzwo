package com.Esprit.sim.kidzwo.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.Esprit.sim.kidzwo.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.Esprit.sim.kidzwo.Entities.Connexion;
import com.Esprit.sim.kidzwo.Entities.Question;
import com.Esprit.sim.kidzwo.Entities.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FrenchNiveau extends AppCompatActivity {
    public static final int REQUEST_CODE = 10 ;
    public TextView enonce ;
    public String niveau,categorie;
    public Button rep1,rep2,rep3,rep4 ;
    TextView score;


    String url,urlt;
    RequestQueue queue ;
    List<Question> listQuestion = new ArrayList<>();
    public int i = 0 ;
    public String Repppv = "";

    private class MyAsyncTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected void onPreExecute() {
            findQuestion();
        }

        @Override
        protected Void doInBackground(Void... params) {
            init();
            return null;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french_niveau);
        Bundle extras = getIntent().getExtras();
        assert extras != null;
        Log.e("zzzzzz", extras.getString("niveau"));
        Log.e("zzzzzz", extras.getString("catt"));
        niveau= extras.getString("niveau");
        categorie= extras.getString("catt");
        score = (TextView) findViewById(R.id.score);
        score.setText("Score: "+ User.scorefrench);
        new MyAsyncTask().execute();
    }

    private void init() {
        final Bundle extras = getIntent().getExtras();
        assert extras != null;
        enonce = findViewById(R.id.question);
        rep1 = findViewById(R.id.rep1);
        rep2 = findViewById(R.id.rep2);
        rep3 = findViewById(R.id.rep3);
        rep4 = findViewById(R.id.rep4);
        rep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rep1.getText().equals(Repppv))
                {
                    if(User.scorefrench < 30 && extras.getString("niveau").equals("Niveau1"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }
                    else if(User.scorefrench < 60 && extras.getString("niveau").equals("Niveau2"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }
                    else if(User.scorefrench < 90 && extras.getString("niveau").equals("Niveau3"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }


                    //rep1.setBackgroundColor(Color.GREEN);
                    //rep1.setBackgroundColor(Color.parseColor("FFFFBB33"));

                }

                suivant(enonce,rep1,rep2,rep3,rep4);

                //findQuestion(enonce,rep1,rep2,rep3,rep4);
            }
        });

        rep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rep2.getText().equals(Repppv))
                {
                    if(User.scorefrench < 30 && extras.getString("niveau").equals("Niveau1"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }
                    else if(User.scorefrench < 60 && extras.getString("niveau").equals("Niveau2"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }
                    else if(User.scorefrench < 90 && extras.getString("niveau").equals("Niveau3"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }
                    else if(User.scorefrench < 120 && extras.getString("niveau").equals("Niveau4"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }

                    //rep2.setBackgroundColor(Color.GREEN);
                    //rep2.setBackgroundColor(Color.parseColor("FFFFBB33"));


                }

                suivant(enonce,rep1,rep2,rep3,rep4);
                //findQuestion(enonce,rep1,rep2,rep3,rep4);
            }
        });

        rep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rep3.getText().equals(Repppv))
                {
                    if(User.scorefrench < 30 && extras.getString("niveau").equals("Niveau1"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }
                    else if(User.scorefrench < 60 && extras.getString("niveau").equals("Niveau2"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }
                    else if(User.scorefrench < 90 && extras.getString("niveau").equals("Niveau3"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }
                    else if(User.scorefrench < 120 && extras.getString("niveau").equals("Niveau4"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }


                    //rep3.setBackgroundColor(Color.GREEN);
                    //rep3.setBackgroundColor(Color.parseColor("FFFFBB33"));

                }
                suivant(enonce,rep1,rep2,rep3,rep4);
                //findQuestion(enonce,rep1,rep2,rep3,rep4);
            }
        });

        rep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rep4.getText().equals(Repppv))
                {
                    if(User.scorefrench < 30 && extras.getString("niveau").equals("Niveau1"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }
                    else if(User.scorefrench < 60 && extras.getString("niveau").equals("Niveau2"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }
                    else if(User.scorefrench < 90 && extras.getString("niveau").equals("Niveau3"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }
                    else if(User.scorefrench < 120 && extras.getString("niveau").equals("Niveau4"))
                    {
                        User.scorefrench+=5;
                        score.setText("Score: "+ User.scorefrench);

                        updateScore(User.id,User.scorefrench);
                        verifScore();
                    }

                    //rep4.setBackgroundColor(Color.GREEN);
                    //rep4.setBackgroundColor(Color.parseColor("FFFFBB33"));


                }
                suivant(enonce,rep1,rep2,rep3,rep4);
                //findQuestion(enonce,rep1,rep2,rep3,rep4);
            }
        });
    }

    public void findQuestion()
    {
        queue = Volley.newRequestQueue(this);
        url = Connexion.url+"questionN1/";
        url += niveau +"/"+categorie;
        StringRequest getData = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    if (obj.getInt("success") == 1) {
                        JSONArray row = new JSONArray(obj.getString("result"));
                        for ( int j=0 ; j < row.length() ; j++) {
                            JSONObject use = row.getJSONObject(j);
                            Question question = new Question(use.getInt("id"),
                                    use.getString("enonce"),
                                    use.getString("repf1"),
                                    use.getString("repf2"),
                                    use.getString("repf3"),
                                    use.getString("repv"));
                            listQuestion.add(question);
                            Log.e("enonce: ", question.enonce);
                            /*enonce.setText(Question.enonce);
                            rep1.setText(Question.repf1);
                            rep2.setText(Question.repf2);
                            rep3.setText(Question.repf3);
                            rep4.setText(Question.repfv);*/
                            Log.e("idddddddddd", String.valueOf(question.id));
                            //updateQuestion(Question.id);
                            if(i==0){
                                List<String> reps = new ArrayList<>();
                                reps.add(listQuestion.get(i).repf1);
                                reps.add(listQuestion.get(i).repf2);
                                reps.add(listQuestion.get(i).repf3);
                                reps.add(listQuestion.get(i).repfv);
                                Repppv = listQuestion.get(i).repfv;
                                Random r = new Random();
                                Log.e("aaaaaaaaaaaaaaaaaaaa ", String.valueOf(r.nextInt(3)));
                                String a = "" ;
                                a = reps.get(r.nextInt(4));
                                rep1.setText(a);
                                reps.remove(a);
                                a = reps.get(r.nextInt(3));
                                rep2.setText(a);
                                reps.remove(a);
                                a = reps.get(r.nextInt(2));
                                rep3.setText(a);
                                reps.remove(a);
                                rep4.setText(reps.get(0));
                                enonce.setText(listQuestion.get(i).enonce);
                                i++;
                            }
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
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
    }

    public void suivant(final TextView enonce, final Button rep1, final Button rep2, final Button rep3, final Button rep4){

        if (i != listQuestion.size()) {
            List<String> reps = new ArrayList<>();
            reps.add(listQuestion.get(i).repf1);
            reps.add(listQuestion.get(i).repf2);
            reps.add(listQuestion.get(i).repf3);
            reps.add(listQuestion.get(i).repfv);
            Repppv = listQuestion.get(i).repfv;

            Random r = new Random();
            Log.e("aaaaaaaaaaaaaaaaaaaa ", String.valueOf(r.nextInt(3)));
            String a = "" ;
            a = reps.get(r.nextInt(4));
            rep1.setText(a);
            reps.remove(a);
            a = reps.get(r.nextInt(3));
            rep2.setText(a);
            reps.remove(a);
            a = reps.get(r.nextInt(2));
            rep3.setText(a);
            reps.remove(a);
            rep4.setText(reps.get(0));
            enonce.setText(listQuestion.get(i).enonce);
            i++;
        }else
        {
            Intent retour = new Intent(FrenchNiveau.this,French.class);
            retour.putExtra("cat","French");
            startActivityForResult(retour,REQUEST_CODE);
            //User.score=0;
            //updateScore(User.id,User.score);
        }


        //rep1.setText(listQuestion.get(i).repf1);
    }


    public void updateScore(int id,int score)
    {
        urlt = Connexion.url+"updateSF/";
        urlt +=id +"/"+score;
        StringRequest getData = new StringRequest(Request.Method.GET, urlt, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    if (obj.getInt("success") == 1) {

                        //Toast.makeText(getApplicationContext(), "next", Toast.LENGTH_SHORT).show();

                    } else
                        Toast.makeText(getApplicationContext(), "profil non modifier", Toast.LENGTH_LONG).show();
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

    }

    public void verifScore()
    {
        if (User.scorefrench == 30)
        {
            MyCustomAlertDialog();
            //Toast.makeText(getApplicationContext(), "Vous avez débloqué le niveau 2", Toast.LENGTH_LONG).show();
        }
        else if (User.scorefrench == 60)
        {
            MyCustomAlertDialog();
            //Toast.makeText(getApplicationContext(), "Vous avez débloqué le niveau 3", Toast.LENGTH_LONG).show();
        }


    }

    public void MyCustomAlertDialog(){
        final Dialog MyDialog = new Dialog(FrenchNiveau.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.custom_dialog);

        Button hello = (Button)MyDialog.findViewById(R.id.hello);
        Button close = (Button)MyDialog.findViewById(R.id.close);

        hello.setEnabled(true);
        close.setEnabled(true);

        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retour = new Intent(FrenchNiveau.this,French.class);
                retour.putExtra("cat","French");
                startActivityForResult(retour,REQUEST_CODE);
                //Toast.makeText(getApplicationContext(), "Hello, I'm Custom Alert Dialog", Toast.LENGTH_LONG).show();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.cancel();
            }
        });

        MyDialog.show();
    }
}

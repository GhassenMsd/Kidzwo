package com.Esprit.sim.kidzwo.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.Esprit.sim.kidzwo.Entities.CustomVolleyRequest;
import com.Esprit.sim.kidzwo.Fragments.Grid;
import com.Esprit.sim.kidzwo.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
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

public class QiNiveau extends AppCompatActivity {
    public static final int REQUEST_CODE = 10 ;

    public TextView enonce ;
    public Button rep1,rep2,rep3,rep4 ;
    NetworkImageView previewImage;
    ImageLoader imageLoader;
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
        setContentView(R.layout.activity_qi_niveau);
        Bundle extras = getIntent().getExtras();
        assert extras != null;
        score = (TextView) findViewById(R.id.score);
        score.setText("Score: "+ User.scoreqi);
        new MyAsyncTask().execute();
    }
    private void init() {
        final Bundle extras = getIntent().getExtras();
        assert extras != null;
        enonce = findViewById(R.id.question);
        previewImage = findViewById(R.id.previewImage);
        rep1 = findViewById(R.id.rep1);
        rep2 = findViewById(R.id.rep2);
        rep3 = findViewById(R.id.rep3);
        rep4 = findViewById(R.id.rep4);
        rep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rep1.getText().equals(Repppv))
                {

                        User.scoreqi+=5;
                        score.setText("Score: "+ User.scoreqi);

                        updateScore(User.id,User.scoreqi);

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

                        User.scoreqi+=5;
                        score.setText("Score: "+ User.scoreqi);

                        updateScore(User.id,User.scoreqi);


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

                        User.scoreqi+=5;
                        score.setText("Score: "+ User.scoreqi);

                        updateScore(User.id,User.scoreqi);



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

                        User.scoreqi+=5;
                        score.setText("Score: "+ User.scoreqi);

                        updateScore(User.id,User.scoreqi);


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
        url += "Niveau1" +"/"+"Qi";
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
                                    use.getString("repv"),
                                    use.getString("photo"));

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
                                Log.e("imaaagggeeeeee", question.photo);
                                imageLoader = CustomVolleyRequest.getInstance(getApplicationContext())
                                        .getImageLoader();
                                imageLoader.get(Connexion.urlimage+listQuestion.get(i).photo, ImageLoader.getImageListener(previewImage
                                        ,0,android.R.drawable
                                                .ic_dialog_alert));
                                previewImage.setImageUrl(Connexion.urlimage+listQuestion.get(i).photo, imageLoader);
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

            imageLoader.get(Connexion.urlimage+listQuestion.get(i).photo, ImageLoader.getImageListener(previewImage
                    ,0,android.R.drawable
                            .ic_dialog_alert));
            previewImage.setImageUrl(Connexion.urlimage+listQuestion.get(i).photo, imageLoader);
            i++;
        }else
        {
            Intent retour = new Intent(QiNiveau.this, Grid.class);
            retour.putExtra("cat","Qi");
            startActivityForResult(retour,REQUEST_CODE);
            //User.score=0;
            //updateScore(User.id,User.score);
        }


        //rep1.setText(listQuestion.get(i).repf1);
    }


    public void updateScore(int id,int score)
    {
        urlt = Connexion.url+"updateSQ/";
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

}

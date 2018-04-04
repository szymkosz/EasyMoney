//package com.example.emilyhowing.secondconscience;
//
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.View;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//
//public class Conscience extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_conscience);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//
//    public boolean conscience(String text){
//
////        public static float score = 1;
//        try {
//            //todo: make this happen in asynctask
//
//            //SentimentAsyncTask task=new SentimentAsyncTask();
//            float score1 = 1;
//            SentimentAsyncTask asyncTask =new SentimentAsyncTask(new AsyncResponse(){
//                @Override
//                void processFinish(String output){
//                    //Here you will receive the result fired from async class
//                    //of onPostExecute(result) method.
//                    String ret = prettify(output);
//                    score = HttpUrlConnect.findScore(ret);
//                }
//            }).execute(text);
//
//            //execute the async task
//            //task.execute();
//            //String s = task.execute().get();
//            //Log.d("TAG3", s);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return score;
//        //System.out.println("score: " + score);
//    }
//
//}

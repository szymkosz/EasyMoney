package com.example.bella.secondconscience;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class content extends AppCompatActivity {
  static TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        tv1 = (TextView) findViewById(R.id.textView3);
        final Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, tv1.getText(), Toast.LENGTH_SHORT);
        toast.show();

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }
        public static void setText() {

        tv1.setText("hiiiiiii");
        }
    }




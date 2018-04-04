package com.example.bella.secondconscience;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
   // private ArrayList<Salon> mSalons = new ArrayList<>();
  //  private SalonAdapter mSalonAdapter;
    //ArrayList<Salon> names;
    static TextView tv1;
   // final Context context = getApplicationContext();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        tv1 = (TextView) (findViewById(R.id.textView3));
        //System.out.print(tv1);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
       tv1.setText(getIntent().getExtras().getString("what_i_need"));
        //Context context = getApplicationContext();
        //recyclerview used to create layout for main activty
        //mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    //    names = new ArrayList<>();

        //Salon a = new Salon();
        //a.setName("Sarah Smith");
        //a.setMessage("I just passed my exam!!!");
        //names.add(a);
        //fab used to start the add a salon activity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addInfo = new Intent(MainActivity.this, AddInfo.class);
                startActivity(addInfo);
                onPause();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              not();
            }
        });


      //  FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
       // DatabaseReference salonReference = firebaseDatabase.getReference("Salons");
       // final CountDownLatch writeSignal = new CountDownLatch(1);
        //child listener gets all of the salons and adds them to the arraylist - the arraylist is used for the recycler view
        /*salonReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("CHILD", dataSnapshot.toString());
                names.add(dataSnapshot);
                mRecyclerView.setAdapter(mSalonAdapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d("CHILD", dataSnapshot.toString());
                names.remove(dataSnapshot);
                mRecyclerView.setAdapter(mSalonAdapter);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/


      //  mSalonAdapter = new SalonAdapter(names);
    }
    @Override
    public void onPause(){

        super.onPause();
    }
    public void not(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("You have been tagged in a potential cyber bullying post.")
                .setMessage("Would you like to report the user?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Yes button clicked, do something
                        Toast.makeText(MainActivity.this, "User Reported",
                                Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Yes button clicked, do something
                        Toast.makeText(MainActivity.this, "Notification Ignored",
                                Toast.LENGTH_LONG).show();
                    }
                })						//Do nothing on no
                .show();
    }

    @Override
    public void onResume(){
        super.onResume();


    }


}




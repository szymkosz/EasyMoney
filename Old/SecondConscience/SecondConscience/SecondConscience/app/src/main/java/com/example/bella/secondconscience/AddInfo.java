package com.example.bella.secondconscience;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Alecia on 4/29/2017.
 */

public class AddInfo extends Activity {

    ImageView imageView;
    //Creates firebase reference
//    final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
 //   DatabaseReference infoReference;
//    final Context context = getApplicationContext();
static String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_prompt);

        //creates editText variables that matches the ids in the XML

        final EditText editTextName = (EditText) findViewById(R.id.name);
       /* final EditText editTextServ = (EditText) findViewById(R.id.services);
        final EditText editTextStyl = (EditText) findViewById(R.id.stylist);
        final EditText editTextRat = (EditText) findViewById(R.id.rating);
        final EditText editTextAddress = (EditText) findViewById(R.id.address);
        final EditText editTextNum = (EditText) findViewById(R.id.phoneNumber);
        final EditText editTexthours = (EditText) findViewById(R.id.hours);
        imageView = (ImageView) findViewById(R.id.image);*/
        Button button = (Button) findViewById(R.id.done);
     //   final Button addButton = (Button) findViewById(R.id.addImage);
        //listener used to get the inputed values when the user clicks the done button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = editTextName.getText().toString();
                MainActivity.tv1.setText(name);
                conscience(name);
               // Toast toast = Toast.makeText(context, name, Toast.LENGTH_SHORT);
                //toast.show();
               // String serivce = editTextServ.getText().toString();
                //String stylist = editTextStyl.getText().toString();
                //String rating = editTextRat.getText().toString();
                //String address = editTextAddress.getText().toString();
                //String phoneNum = editTextNum.getText().toString();
                //String hours = editTexthours.getText().toString();
               // infoReference = firebaseDatabase.getReference("Salons/" + name);
               // infoReference.child("Name").setValue(name);
               /* infoReference.child("Address").setValue(address);
                infoReference.child("Phone").setValue(phoneNum);
                infoReference.child("Hours").setValue(hours);
                infoReference.child("Service").setValue(serivce);
                infoReference.child("Stylist").setValue(stylist);
                infoReference.child("Rating").setValue(rating);
                infoReference.child("Comments").setValue("");*/
            //    makeNotification();

                //Intent made to go to the next activity


            }
        });
      /*  addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto, 1);
            }
        });*/


    }

    //Method used to get image from gallery and open gallery
   /* protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case 0:
                if (resultCode == RESULT_OK) {

                    Uri selectedImage = imageReturnedIntent.getData();
                    imageView.setImageURI(selectedImage);

                }

                break;
            case 1:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    imageView.setImageURI(selectedImage);

                }
                break;
        }
    }*/
    void conscience(String text){

        if(true){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder
                    .setTitle("Your message could be hurtful to others.")
                    .setMessage("Are you sure you want to post this?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Yes button clicked, do something
                            Toast.makeText(AddInfo.this, "Message Posted",
                                    Toast.LENGTH_LONG).show();
                            Intent addInfo = new Intent(AddInfo.this, MainActivity.class);
                            addInfo.putExtra("what_i_need", name);
                            startActivity(addInfo);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Yes button clicked, do something
                            Toast.makeText(AddInfo.this, "Message Deleted",
                                    Toast.LENGTH_LONG).show();
                            Intent addInfo = new Intent(AddInfo.this, MainActivity.class);
                            startActivity(addInfo);
                        }
                    })						//Do nothing on no
                    .show();
        }


    }
    //method used to push a notification when a salon is added
    private void makeNotification() {
        NotificationCompat.Builder mbuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Snatched")
                        .setContentText("A New Salon Has Been Added! Tap to Check it out.");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mbuilder.setContentIntent(contentIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, mbuilder.build());
    }

}




package com.example.complaintsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MakeComplaintActivity extends AppCompatActivity {

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_complaint);

      submit = findViewById(R.id.btn_submit);

      submit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              messageSuccess();
          }
      });

    }

   void messageSuccess (){
       // Inflate the custom layout
       LayoutInflater inflater = getLayoutInflater();
       View layout = inflater.inflate(R.layout.dialog_message_success, null);

// Set the message text
       TextView textViewMessage = layout.findViewById(R.id.txt_message);
       textViewMessage.setText("Message sent successfully!");

// Set the click listener for the OK button
       Button buttonOk = layout.findViewById(R.id.btn_ok);
       buttonOk.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // Do something when the OK button is clicked
               Dialog dialog = new Dialog(getApplicationContext());
               dialog.dismiss();
               Intent userDashBoardIntent = new Intent(getApplicationContext(), user_dash_board.class);
               startActivity(userDashBoardIntent);
           }
       });

// Create and show the dialog
       AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setView(layout);
       AlertDialog dialog = builder.create();
       dialog.show();
    }
}
package com.example.complaintsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class user_dash_board extends AppCompatActivity {

    Button btnMakeComplaint;
    Button btnComplaintHistory;
    Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dash_board);

        btnMakeComplaint = findViewById(R.id.btn_make_complaint);
        btnComplaintHistory = findViewById(R.id.btn_complaint_history);
        btnLogOut = findViewById(R.id.btn_logout);

        btnMakeComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent makeComplaintIntent = new Intent(getApplicationContext(), MakeComplaintActivity.class);

                startActivity(makeComplaintIntent);
            }
        });

        btnComplaintHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent complaintHistoryIntent = new Intent(getApplicationContext(), ComplaintHistory.class);
                startActivity(complaintHistoryIntent);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logOutIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(logOutIntent);
            }
        });
    }
}
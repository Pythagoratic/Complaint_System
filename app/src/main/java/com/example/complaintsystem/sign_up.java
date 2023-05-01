package com.example.complaintsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sign_up extends AppCompatActivity {

    TextView txtSignIn;

    Spinner spinner;

    EditText edtFullName;
    EditText edtEmail;
    EditText edtRegNumber;
    EditText edtPhoneNumber;
    EditText edtFaculty;
    EditText edtDepartment;
    EditText edtPassword;

    Button btnCreateAccount;

    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

       spinner = findViewById(R.id.faculty_spinner);
        txtSignIn = findViewById(R.id.txt_sign_in);

        edtFullName = findViewById(R.id.edittext_full_name);
        edtEmail = findViewById(R.id.edittext_email);
        edtRegNumber = findViewById(R.id.edittext_reg_number);
        edtPhoneNumber = findViewById(R.id.edittext_phone_number);
        edtFaculty = findViewById(R.id.edittext_faculty);
        edtDepartment = findViewById(R.id.edittext_department);
        edtPassword = findViewById(R.id.edittext_password);

        btnCreateAccount = findViewById(R.id.btn_create_account);






        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.unizik_faculty_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.faculty_spinner);
        spinner.setAdapter(adapter);



        edtFaculty.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                spinner.performClick();
                return true;
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedFaculty = parent.getItemAtPosition(position).toString();
                edtDepartment.setText("hello world");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = new Intent(getApplicationContext(), LoginActivity.class);

                startActivity(signInIntent);
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("registrationDetails");


                String fullName = edtFullName.getText().toString();
                String email =  edtEmail.getText().toString();
                String regNumber = edtRegNumber.getText().toString();
                String phoneNumber = edtPhoneNumber.getText().toString();
                String faculty = edtFaculty.getText().toString();
                String department = edtDepartment.getText().toString();
                String password = edtPassword.getText().toString();

                RegistrationDetails registrationDetails = new RegistrationDetails(fullName,email,regNumber,phoneNumber,
                        faculty,department,password);



                databaseRef.setValue(registrationDetails);

                DatabaseReference newRef = databaseRef.push();
                newRef.setValue(registrationDetails);

                databaseRef.setValue(registrationDetails, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError != null) {
                            // Handle the error
                            Toast.makeText(getApplicationContext(),"Sorry Error Happened", Toast.LENGTH_LONG);
                        } else {
                            Toast.makeText(getApplicationContext(),"SUCCESSFUL!!!", Toast.LENGTH_LONG);
                            // Write operation was successful
                        }
                    }
                });

            }
        });
    }


}
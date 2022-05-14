package com.example.t024_insertquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertActivity extends AppCompatActivity {

    EditText quote ;
    Button BtnSave ;
    DatabaseReference databaseReference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        quote = findViewById(R.id.quote);
        BtnSave = findViewById(R.id.BtnSave);
        databaseReference = FirebaseDatabase.getInstance().getReference("Model");
        Intent intent = getIntent();

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String QUOTE = quote.getText().toString().trim();
               String QUOTE_CAT = intent.getStringExtra("QUOTE_CAT_KEY");
               String QUOTE_CAT_NO = intent.getStringExtra("QUOTE_CAT_NO_KEY");

               if (QUOTE.isEmpty()){
                   quote.setError("Quote is Required");
                   quote.requestFocus();
                   return;
               }

                String ID = databaseReference.push().getKey();
                Model model = new Model(ID , QUOTE_CAT , QUOTE_CAT_NO , "1" , QUOTE);

                databaseReference.child(ID).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            quote.setText("");
                        }
                        else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage() , Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}
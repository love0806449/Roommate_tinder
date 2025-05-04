package com.example.swipecard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registActivity extends AppCompatActivity {
    Button mbacklog,mregist;
    EditText mregEmail,mregpassword;
    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_regist);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mregEmail = findViewById(R.id.editTextEmail2);
        mregpassword = findViewById(R.id.editTextNumberPassword2);

        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
            }
        };
        mbacklog = findViewById(R.id.backloginbutton);
        mbacklog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });
        mregist = findViewById(R.id.regbutton);
        mregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regemail = mregEmail.getText().toString();
                String regpsw = mregpassword.getText().toString();
                auth.createUserWithEmailAndPassword(regemail,regpsw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(registActivity.this,"註冊成功",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(registActivity.this, loginActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(registActivity.this,"註冊失敗",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
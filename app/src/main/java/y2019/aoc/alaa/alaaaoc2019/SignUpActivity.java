package y2019.aoc.alaa.alaaaoc2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextEmail, editTextFName, editTextLName, editTextUName, editTextPassword;
    Button buttonSignUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextFName = findViewById(R.id.editTextFirstName);
        editTextLName = findViewById(R.id.editTextLastName);
        editTextUName = findViewById(R.id.editTextUsertName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignUp = findViewById(R.id.buttonLogIn);
        buttonSignUp.setOnClickListener(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void signUp(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(SignUpActivity.this, MainActivity.class);
                            startActivity(i);

                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FirbaseAuth", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            int firbaseAuth = Log.w("createUserWithEmail:failure"

                                    , "FirbaseAuth", task.getException());

                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });


    }


    @Override
    public void onClick(View v) {
        if (v == buttonSignUp) {
            if (editTextEmail.getText().toString().equals("") || editTextPassword.getText().toString().equals("")||editTextFName.getText().toString().equals("") || editTextLName.getText().toString().equals("") || editTextUName.getText().toString().equals("")){
                Toast.makeText(this,"empty methods",Toast.LENGTH_LONG).show();
            }
            else {
                signUp(editTextEmail.getText().toString(), editTextPassword.getText().toString());

            }
        }

    }
}

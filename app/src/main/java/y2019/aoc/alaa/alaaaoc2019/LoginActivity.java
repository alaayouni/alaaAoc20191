package y2019.aoc.alaa.alaaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //I. properties defenition
    EditText editTextEmail, editTextPassword;
    Button buttonLogIn;
    Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //2. initialize properies
        editTextEmail = findViewById (R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        buttonLogIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==buttonLogIn){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }else {

            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);

        }
        }
    }



package y2019.aoc.alaa.alaaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextEmail, editTextFName, editTextLName, editTextUName, editTextPassword;
    Button buttonLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextFName=findViewById(R.id.editTextFirstName);
        editTextLName=findViewById(R.id.editTextLastName);
        editTextUName=findViewById(R.id.editTextUsertName);
        editTextPassword=findViewById(R.id.editTextPassword);
        buttonLogIn=findViewById(R.id.buttonLogIn);
        buttonLogIn.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if (v==buttonLogIn){
        Intent i = new Intent(this, MainActivity.class);
       i.putExtra("email",editTextEmail.getText().toString());
       i.putExtra("password", editTextPassword.getText().toString());
       startActivity(i);}
    }
}

package y2019.aoc.alaa.alaaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class SafeRoudActivity extends AppCompatActivity  implements View.OnClickListener{


   Button buttonLogIn, buttonSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe_roud);
        buttonLogIn=findViewById(R.id.buttonLogIn);
        buttonSignUp=findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(this);
        buttonLogIn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v==buttonSignUp){

        Intent i = new Intent(this,SignUpActivity.class);
        startActivity(i);}

        if (v==buttonLogIn){
        Intent i  = new Intent(this,LoginActivity.class);
        startActivity(i);}


    }
}


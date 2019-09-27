package y2019.aoc.alaa.alaaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class SafeRoudActivity extends AppCompatActivity {


    //Button buttonLogIn, buttonSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe_roud);
      //  buttonLogIn=findViewById(R.id.buttonLogIn);
        //buttonSignUp=findViewById(R.id.buttonSignUp);

        //buttonLogIn = findViewById(R.id.buttonLogIn);
        //buttonLogIn.setOnClickListener(this);

        //buttonSignUp = findViewById(R.id.buttonSignUp);
        //buttonSignUp.setOnClickListener(this);



    }

   // @Override
    public void onClick(View v) {

        Intent i = new Intent(this,SignUpActivity.class);
        startActivity(i);
    }
}


package y2019.aoc.alaa.alaaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }



    @Override
    public void onClick(View v) {

        Intent i = new Intent(this, LoginActivity.class);

     //   i.putExtra("email",editTextEmail.getText().toString());
      //+  i.putExtra("password", editTextPassword.getText().toString());
        startActivity(i);
    }
}

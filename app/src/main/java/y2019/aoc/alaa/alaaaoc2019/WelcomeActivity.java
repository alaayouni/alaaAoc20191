package y2019.aoc.alaa.alaaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity  implements View.OnClickListener {

    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tvWelcome = findViewById(R.id.tvWelcome);
        tvWelcome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}

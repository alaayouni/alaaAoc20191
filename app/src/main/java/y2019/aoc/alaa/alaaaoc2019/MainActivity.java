package y2019.aoc.alaa.alaaaoc2019;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvEmail, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String password =getIntent().getStringExtra("password");
        String email =getIntent().getStringExtra("email");
        tvEmail = findViewById(R.id.tvEmail);
        tvPassword = findViewById(R.id.tvpPsssword);
        tvEmail.setText(email);
        tvPassword.setText(password);










    }

}

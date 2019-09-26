package y2019.aoc.alaa.alaaaoc2019;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvEmail, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String password =getIntent().getStringExtra("password");
        String email =getIntent().getStringExtra("email");
     //   tvEmail = findViewById(R.id.tvEmail);
       // tvPassword = findViewById(R.id.tvpPsssword);
     //   tvEmail.setText(email);
     //   tvPassword.setText(password);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.mnItmPicture:
                Toast.makeText(getBaseContext(), "Hi Picture", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnItmLogOut:
                Toast.makeText(getBaseContext(), "Hi LogOut", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;

       // return super.onOptionsItemSelected(item);
    }
}

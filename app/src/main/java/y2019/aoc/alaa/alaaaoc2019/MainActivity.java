package y2019.aoc.alaa.alaaaoc2019;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;


        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class
MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvLocation;
    TextView tvWhatH;
    EditText editTextWhatH;
    TextView tvDone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.
                layout.activity_main);
        //String password =getIntent().getStringExtra("password");
        //String email =getIntent().getStringExtra("email");
       tvWhatH = findViewById(R.id.textViewWh);
       editTextWhatH = findViewById(R.id.editTextWH);
        //tvWhatH.setOnClickListener(this);
        tvDone = findViewById(R.id.tvDONE);
        tvDone.setOnClickListener(this);
        tvLocation = findViewById(R.id.location);
        tvLocation.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return  super.onCreateOptionsMenu(menu);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent goToLogOutActivity;
        Intent goToCameraActivity;



        switch (item.getItemId()) {
            case R.id.mnItmPicture:
                goToCameraActivity = new Intent(getApplicationContext(), CameraActivity.class);
                startActivity(goToCameraActivity);
                Toast.makeText(getBaseContext(), "Hi Picture", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnItmLogOut:
                AlertDialog.Builder Builder = new AlertDialog.Builder(MainActivity.this);
                Builder.setMessage("Are you sure you wanna leave?").setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent goToLogOutActivity;
                                goToLogOutActivity = new Intent(getApplicationContext(), WelcomeActivity.class);
                                startActivity(goToLogOutActivity);
                                Toast.makeText(getBaseContext(), "Hi ", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });


        }



return true;




        }


       // return super.onOptionsItemSelected(item);


    @Override
    public void onClick(View v) {
        if (v == tvLocation) {

            Intent i = new Intent(this, MapsActivity.class);
            startActivity(i);

        }
    }
}


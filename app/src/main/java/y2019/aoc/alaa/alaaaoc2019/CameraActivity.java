package y2019.aoc.alaa.alaaaoc2019;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    Bitmap bitmap;
    ImageView imageView;
    private static final int SELECT_IMAGE = 1;
    Button btGallery;



    private static final int CAMERA_REQUEST = 0;
    Button btTakePhot;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        imageView=findViewById(R.id.ImageButton);
        btGallery =findViewById(R.id.Gallery);
        btTakePhot =findViewById(R.id.Camera);
        imageView.setOnClickListener(this);
        btTakePhot.setOnClickListener(this);
        btGallery.setOnClickListener(this);



    }

    public void onClick(View view) {

        if (view == btTakePhot) {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, CAMERA_REQUEST);
        } else {
            Intent i =new
                    Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, SELECT_IMAGE);
        }



    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {

            bitmap = (Bitmap) data.getExtras().get("data");

            imageView.setImageBitmap(bitmap);
        }


        else if(requestCode == SELECT_IMAGE &&resultCode == Activity.RESULT_OK) {

            Uri targetUri = data.getData();
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
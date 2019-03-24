package com.clorify.clorify;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {
    private Button capture;
    private Button test;
    private EditText mname;
    private EditText deffect;
    private static final int REQUEST_CAPTURE_IMAGE = 100;
   // private ImageView mImageView;
    private String imageFilePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        capture=findViewById(R.id.opencamera);
        test=findViewById(R.id.colour_blindtest);
        deffect=findViewById(R.id.deffect);
        mname=findViewById(R.id.name);


        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent testIntent = new Intent(HomeActivity.this,Test_colorBlindness.class);
                startActivity(testIntent);
            }
        });
    //    mImageView = findViewById(R.id.imageView);
        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pictureIntent = new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE);
                if (pictureIntent.resolveActivity(getPackageManager()) != null) {

                    File photoFile = null;
                    try {
                        photoFile = createImageFile();
                    } catch (IOException ex) {

                    }
                    if (photoFile != null) {

                        URI photoURI= photoFile.toURI();
                        //  Uri photoURI = FileProvider.getUriForFile(MainActivity.this, "com.example.android.provider", photoFile);
                        Log.d("URI",photoURI.toString()+" ");
                        pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                photoURI);
                        startActivityForResult(pictureIntent,
                                REQUEST_CAPTURE_IMAGE);
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == 100) {
            Log.d("image",data.toString());

            Uri myUri = Uri.parse(imageFilePath);

      //      Picasso.with(HomeActivity.this).load(myUri).into(mImageView);
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            mImageView.setImageBitmap(photo);


        }
    }



    private File createImageFile() throws IOException {
        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss",
                        Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp + "_";
        File storageDir =
                getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        imageFilePath = image.getAbsolutePath();
        return image;
    }
}

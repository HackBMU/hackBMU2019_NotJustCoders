package com.clorify.clorify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class imagedisplay extends AppCompatActivity {
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagedisplay);
        Intent intent= getIntent();
        Bitmap photo=(Bitmap) intent.getExtras().get("photo");
        imageView=findViewById(R.id.imageView);
        imageView.setImageBitmap(photo);

    }
}

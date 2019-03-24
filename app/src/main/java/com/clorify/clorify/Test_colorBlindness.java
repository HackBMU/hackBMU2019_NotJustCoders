package com.clorify.clorify;

import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Test_colorBlindness extends AppCompatActivity {
private Random rand;
private int random;
private int red;
public Timer timer;
private int blue;
private  int green;
public int count;
private Handler handler;
private Runnable Update;
private GridLayout layout;
private String result;
private TextView result1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_color_blindness);
          layout = (GridLayout) findViewById(R.id.gridlayout);
        rand=new  Random();
        random=rand.nextInt(16);
        count =1;green=0;blue=0;red=0;
        handler = new Handler();
        setEventonclick(layout);
              setSingleEvent(layout);
              handler.postDelayed(runnable,5000);
              random=rand.nextInt(16);
              count=2;
              handler.postDelayed(runnable,5000);
              random=rand.nextInt(16);count=3;
              handler.postDelayed(runnable,5000);
              result=" ";

              result1=findViewById(R.id.edittext);

    }

    private String getresult() {
        if(red==0||green==0)
        {
            return "red-green";
        }
        if(red==0||blue==0)
        {
            return "blue-yellow";
        }
        else
            return "you dont have color blindness";
    }

    private Runnable runnable =new Runnable() {
       @Override
       public void run() {
           setSingleEvent(layout);
           setEventonclick(layout);

       }
   };

    private void setEventonclick(GridLayout layout) {
        for(int i=0;i<layout.getChildCount();i++)
        {   if(i==random){
            ImageView imageView=(ImageView) layout.getChildAt(i);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(count==1) {
                        red = 1;
                    }
                    else if(count==2){
                        green=1;}
                    else if(count==3)
                    {
                        blue=1;
                      Result();
                    }
                }

                private void Result() {
                    if(red==1&&blue==1)
                        result1.setText("Red_Green Colour blindness");
                    else if(red==1&&blue==0){
                        result1.setText("Red-Green Colour blindness");
                    }else if(blue==1&&red==0){
                        result1.setText("Blue-Yellow Colour blindness");
                    }
                }
            });

        }
        }
    }

    private void setSingleEvent(GridLayout layout) {

        for(int i=0;i<layout.getChildCount();i++)
        {
            ImageView imageView=(ImageView) layout.getChildAt(i);
            int rsc,rsc1;
            rsc1=R.drawable.white;
            rsc=R.drawable.white;
            if(count==1) {
                rsc = R.drawable.green;
                rsc1=R.drawable.red;
            }
            if(count==2){

                rsc=R.drawable.blue;
                rsc1=R.drawable.yellow;
            }
            if(count==3)
            {
                rsc=R.drawable.yellow;
                rsc1=R.drawable.red;
            }
            if(i==random)
            {
                imageView.setImageResource(rsc1);
            }
            else {
                imageView.setImageResource(rsc);

            }

        }
    }
}
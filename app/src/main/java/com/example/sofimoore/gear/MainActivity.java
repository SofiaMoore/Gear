package com.example.sofimoore.gear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.sofimoore.gear.R.styleable.View;

public class MainActivity extends AppCompatActivity {
Button bt1,bt2;
    drawView dr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        dr = (drawView) findViewById(R.id.dr);

    }



    public void onClickBt1(View v){
        dr.speed++;
        dr.speed2++;

    }

    public void onClickBt2(View v){
        dr.speed--;
        dr.speed2--;
        if(dr.speed == 0){
                    dr.stop = false;
                }
          if(dr.speed2 == 0) {
              dr.stop = false;
          }

    }
}

package com.example.hanndler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int seconds;
    private boolean flag=true;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textClock);
        count();
    }

    public void start(View view) {
        flag=true;

    }

    public void pause(View view) {
        flag=false;
    }

    public void restart(View view) {
        flag=false;
        seconds=0;
    }
    public void count(){
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour=seconds/3600;
                int minute=seconds%3600/60;
                int sec=seconds-minute*60-hour*3600;
                String result=String.format(Locale.getDefault(),"%d:%02d:%02d",hour,minute,sec);
                textView.setText(result);
                if(flag==true){
                    seconds++;
                }

                handler.postDelayed(this,1000);

            }
        });

    }
}

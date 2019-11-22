package com.bw.activityget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    public static final String TAG = "Main2Activity";
    private Button btn_one;
    private Button btn_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        Log.e(TAG, "onCreate: ");
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_a,new OneFragment()).commit();
            }
        });
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_a,new TwoFragment()).commit();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    private void initView() {
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
    }

}

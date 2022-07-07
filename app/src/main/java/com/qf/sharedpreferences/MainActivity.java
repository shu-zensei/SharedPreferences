package com.qf.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String TAG = "myLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences shp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt("NUMBER", 200);
        // 也可以用commit，但是apply是非同步的也就是说多个用户同时提交是允许的，可以避免冲突，commit则同时只允许一个用户提交
        editor.apply();

        // 按照key进行读取，然后设置如果没读取到，默认值是0
        int number = shp.getInt("NUMBER", 0);

        Log.d(TAG, "onCreate : " + number);
    }
}
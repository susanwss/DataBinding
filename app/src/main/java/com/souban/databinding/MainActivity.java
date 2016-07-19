package com.souban.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.souban.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ClickClass {
    private ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.setPresenter(this);
        dataBinding.setName("ceshi");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text:
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text1:
                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text2:
                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

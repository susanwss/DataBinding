package com.souban.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.souban.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ClickClass {
    private ActivityMainBinding dataBinding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.setPresenter(this);
        dataBinding.setName("ceshi");
        user = new User();
        user.setFirstName("ceshi ");
        user.setLastName("ceshi1");
        dataBinding.setUser(user);
        ObservableArrayList<Object> user1 = new ObservableArrayList<>();
        user1.add("Wang");
        user1.add("S");
        user1.add("17");
        dataBinding.setUser1(user1);
    }

    @Override
    public void onContainerClick(View view) {
        switch (view.getId()) {
            case R.id.text:
                Toast.makeText(MainActivity.this, user.getLastName(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.text1:
                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text2:
                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemClick(View view, ObservableMap user) {
        Log.d("wang", view.getId() + "");
        Toast.makeText(MainActivity.this, user.get("firstName").toString(), Toast.LENGTH_SHORT).show();
    }
}

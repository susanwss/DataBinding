package com.souban.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableMap;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.souban.databinding.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity implements ClickClass {
    private ActivityRecyclerViewBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        ArrayList<User> userArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setFirstName(String.valueOf(i + 1));
            userArrayList.add(user);
        }
        dataBinding.recyclerView.setAdapter(new RecyclerViewAdapter(this, userArrayList));

    }

    @Override
    public void onContainerClick(View view) {
        ((ImageView) view).setImageTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary));
    }

    @Override
    public void onItemClick(View view, ObservableMap user) {

    }
}

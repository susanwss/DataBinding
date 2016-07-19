package com.souban.databinding;

import android.databinding.ObservableMap;
import android.view.View;

/**
 * Created by wss on 7/18/16.
 */
public interface ClickClass {
    void onContainerClick(View view);

    void onItemClick(View view, ObservableMap user);
}

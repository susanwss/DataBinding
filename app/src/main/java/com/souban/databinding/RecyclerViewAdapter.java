package com.souban.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.souban.databinding.databinding.ItemListRoomBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wss on 7/19/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<BindViewHolder> {
    private List<User> userList;
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<User> userList) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public BindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListRoomBinding itemListRoomBinding = DataBindingUtil.bind(LayoutInflater.from(context).inflate(R.layout.item_list_room, null, false));
        return new BindViewHolder<>(itemListRoomBinding);
    }

    @Override
    public void onBindViewHolder(BindViewHolder holder, int position) {
        final User item = userList.get(position);
        holder.getBinding().setVariable(BR.item, item);
        holder.getBinding().setVariable(BR.presenter, context);
        holder.getBinding().executePendingBindings();
        holder.getBinding().addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup sceneRoot = (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(sceneRoot);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}

package com.example.mechrevo.xysdemoset.adapter;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.AsyncListDiffer;
import android.support.v7.util.AsyncListUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mechrevo.xysdemoset.R;
import com.example.mechrevo.xysdemoset.bean.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    //通过Utils获取到
    private AsyncListDiffer<User> mUserAsyncListUtil;

    //构造的时候就已经绑定了关系
    public UserAdapter() {
        mUserAsyncListUtil = new AsyncListDiffer<User>(this, diffCallback);
    }

    private DiffUtil.ItemCallback<User> diffCallback = new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(User oldItem, User newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(User oldItem, User newItem) {
            return oldItem.getAge().equals(newItem.getAge());
        }
    };

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new UserViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item, null, true));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mUserAsyncListUtil.getCurrentList().size();
    }

    public void submitList(List<User> list) {
        mUserAsyncListUtil.submitList(list);
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
        }
    }

}


package com.example.mechrevo.xysdemoset.fm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mechrevo.xysdemoset.R;
import com.example.mechrevo.xysdemoset.adapter.BaseDemoAdapter;

import java.net.CookieManager;
import java.util.ArrayList;
import java.util.List;

public class BaseFragment extends Fragment {

    protected View mView;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_base, null);
        return mView;
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d("Bob","onResume");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = mView.findViewById(R.id.text);
        textView.setText(getClass().getSimpleName());
        recyclerView = mView.findViewById(R.id.recycleview);
        BaseDemoAdapter baseDemoAdapter = new BaseDemoAdapter(0);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(baseDemoAdapter);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("位置  " + i);
        }
        baseDemoAdapter.setNewData(list);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_SETTLING:

                        break;
                    case RecyclerView.SCROLL_STATE_IDLE:
                        break;

                    case RecyclerView.SCROLL_STATE_DRAGGING:

                        break;

                    default:
                        break;

                }
            }
        });
    }
}

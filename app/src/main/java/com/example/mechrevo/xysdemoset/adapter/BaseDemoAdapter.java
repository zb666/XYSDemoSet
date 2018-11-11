package com.example.mechrevo.xysdemoset.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mechrevo.xysdemoset.R;

public class BaseDemoAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public BaseDemoAdapter(int layoutResId) {
        super(R.layout.item_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}

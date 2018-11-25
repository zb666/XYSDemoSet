package com.example.mechrevo.xysdemoset.bean;

import android.support.v7.util.DiffUtil;

public class Diff<T extends Diff.IDiffRegularCallback<T>> extends DiffUtil.Callback {

    @Override
    public int getOldListSize() {
        return 0;
    }

    @Override
    public int getNewListSize() {
        return 0;
    }

    @Override
    public boolean areItemsTheSame(int i, int i1) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        return false;
    }
    //要暴露什么
    // 1规则 什么规则？-》比较的规则
    // 2 比较的数据(这个旧的数据项是从原先的old集合中给与出来的
    public interface IDiffRegularCallback<T> {
        boolean isSame(T old);
    }
}

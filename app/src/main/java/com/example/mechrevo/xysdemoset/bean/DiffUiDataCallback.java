package com.example.mechrevo.xysdemoset.bean;


import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */

//抽象思维 暴露本体和比较的规则
public class DiffUiDataCallback<T extends DiffUiDataCallback.DiDataDiffer<T>> extends DiffUtil.Callback {

    private List<T> mOldList, mNewList;

    public DiffUiDataCallback(List<T> oldList, List<T> newList) {
        mOldList = oldList;
        mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    /**
     * 用来判断是否是同一个对象的
     * 比如同一个User取出来的Id是否相同
     *
     * @param
     * @param
     * @return
     */
    @Override
    public boolean areItemsTheSame(int oldList, int newList) {
        return mOldList.get(oldList).isSame(mNewList.get(newList));
    }

    @Override
    public boolean areContentsTheSame(int oldList, int newList) {
        return  mOldList.get(oldList).isContentSame(mNewList.get(newList));
    }

    public interface DiDataDiffer<T> {
        //比如这里比较的是id
        boolean isSame(T old);
        //这里比较的是Id和其他内容
        boolean isContentSame(T old);
    }
}
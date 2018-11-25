package com.example.mechrevo.xysdemoset.bean;

public class TestDiff implements Diff.IDiffRegularCallback<TestDiff> {
    //这里会有新的集合数据
    //同时会有旧的数据这样就可以实现比较了
    @Override
    public boolean isSame(TestDiff old) {
        return false;
    }
}

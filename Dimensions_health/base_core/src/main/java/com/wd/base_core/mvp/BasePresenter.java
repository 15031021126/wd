package com.wd.base_core.mvp;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M, V> {

    public M model;
    public V view;
    private WeakReference<V> weakReference;

    public abstract M getModel();

    //绑定
    public void attach(V view) {
        this.model = getModel();
        weakReference = new WeakReference<>(view);
        this.view = weakReference.get();//得到view
    }


    //解绑
    public void dettach() {
        if (weakReference != null) {
            weakReference.clear();//清空对象
            weakReference = null;
            this.view = null;
        }
        if (model != null) {
            model = null;
        }
    }

}

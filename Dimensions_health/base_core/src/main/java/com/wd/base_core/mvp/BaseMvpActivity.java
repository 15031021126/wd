package com.wd.base_core.mvp;

import com.wd.base_core.base.BaseActivity;

public abstract class BaseMvpActivity<M extends IBaseModel, P extends BasePresenter> extends BaseActivity implements IBaseView {
    public M model;
    public P presenter;

    @Override
    protected void iniData() {

        presenter = (P) initPresenter();
        if (presenter != null) {
            model = (M) presenter.getModel();
            if (model != null) {
                //绑定
                presenter.attach( this);

            }
        }

        init();
    }

    protected abstract void init();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            //解绑
            presenter.dettach();
        }
    }
}

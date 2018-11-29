/*
 * Copyright 2018 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.jessyan.armscomponent.zhihu.mvp.ui.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import javax.inject.Inject;

import butterknife.BindView;
import me.jessyan.armscomponent.commonsdk.core.RouterHub;
import me.jessyan.armscomponent.zhihu.R;
import me.jessyan.armscomponent.zhihu.R2;
import me.jessyan.armscomponent.zhihu.app.ZhihuConstants;
import me.jessyan.armscomponent.commonsdk.utils.HtmlUtil;
import me.jessyan.armscomponent.zhihu.di.component.DaggerDetailComponent;
import me.jessyan.armscomponent.zhihu.mvp.contract.DetailContract;
import me.jessyan.armscomponent.zhihu.mvp.model.entity.ZhihuDetailBean;
import me.jessyan.armscomponent.zhihu.mvp.presenter.DetailPresenter;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * ================================================
 * 展示 View 的用法
 *
 * @see <a href="https://github.com/JessYanCoding/MVPArms/wiki#2.4.2">View wiki 官方文档</a>
 * Created by JessYan on 25/04/2016 10:59
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
@Route(path = RouterHub.ZHIHU_DETAILACTIVITY)
public class DetailActivity extends BaseActivity<DetailPresenter> implements DetailContract.View {
    @BindView(R2.id.webView)
    WebView mWebView;
    @Inject
    Dialog mDialog;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerDetailComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.zhihu_activity_detail; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initWebView();
        loadTitle();
        mPresenter.requestDetailInfo(getIntent().getIntExtra(ZhihuConstants.DETAIL_ID, 0));
    }

    @Override
    public void showLoading() {
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        mDialog.dismiss();
    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    private void initWebView() {
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    private void loadTitle() {
        String title = getIntent().getStringExtra(ZhihuConstants.DETAIL_TITLE);
        if (title.length() > 10) {
            title = title.substring(0, 10) + " ...";
        }
        setTitle(title);
    }

    @Override
    public void shonContent(ZhihuDetailBean bean) {
        String htmlData = HtmlUtil.createHtmlData(bean.getBody(), bean.getCss(), bean.getJs());
        mWebView.loadData(htmlData, HtmlUtil.MIME_TYPE, ZhihuConstants.ENCODING);
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}

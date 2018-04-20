package me.jessyan.armscomponent.app.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.OnClick;
import me.jessyan.armscomponent.app.R;

/**
 * ================================================
 * Created by JessYan on 19/04/2018 16:10
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class MainActivity extends BaseActivity {
    private long mPressedTime;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onBackPressed() {
        long mNowTime = System.currentTimeMillis();//获取第一次按键时间
        if ((mNowTime - mPressedTime) > 2000) {//比较两次按键时间差
            ArmsUtils.makeText(getApplicationContext(),
                    "再按一次退出" + ArmsUtils.getString(getApplicationContext(), R.string.public_app_name));
            mPressedTime = mNowTime;
        } else {
            super.onBackPressed();
        }
    }

    @OnClick({R.id.bt_zhihu, R.id.bt_gank, R.id.bt_gold})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_zhihu:
                break;
            case R.id.bt_gank:
                break;
            case R.id.bt_gold:
                break;
        }
    }
}

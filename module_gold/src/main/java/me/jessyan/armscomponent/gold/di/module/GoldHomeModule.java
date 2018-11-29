/*
 * Copyright 2017 JessYan
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
package me.jessyan.armscomponent.gold.di.module;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.scope.ActivityScope;

import java.util.ArrayList;
import java.util.List;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import me.jessyan.armscomponent.commonsdk.core.RouterHub;
import me.jessyan.armscomponent.gold.app.GoldConstants;
import me.jessyan.armscomponent.gold.mvp.contract.GoldHomeContract;
import me.jessyan.armscomponent.gold.mvp.model.GoldModel;
import me.jessyan.armscomponent.gold.mvp.model.entity.GoldListBean;
import me.jessyan.armscomponent.gold.mvp.ui.adapter.GoldHomeAdapter;

/**
 * ================================================
 * 展示 Module 的用法
 *
 * @see <a href="https://github.com/JessYanCoding/MVPArms/wiki#2.4.5">Module wiki 官方文档</a>
 * Created by JessYan on 09/04/2016 11:10
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
@Module
public abstract class GoldHomeModule {
    @Binds
    abstract GoldHomeContract.Model bindGoldModel(GoldModel model);

    @ActivityScope
    @Provides
    static RecyclerView.LayoutManager provideLayoutManager(GoldHomeContract.View view) {
        return new LinearLayoutManager(view.getActivity());
    }

    @ActivityScope
    @Provides
    static List<GoldListBean> provideList() {
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    static RecyclerView.Adapter provideGoldHomeAdapter(GoldHomeContract.View GoldHomeView, List<GoldListBean> list){
        GoldHomeAdapter adapter = new GoldHomeAdapter(list);
        adapter.setOnItemClickListener(new DefaultAdapter.OnRecyclerViewItemClickListener<GoldListBean>() {
            @Override
            public void onItemClick(View view, int viewType, GoldListBean data, int position) {
                ARouter.getInstance()
                        .build(RouterHub.GOLD_DETAILACTIVITY)
                        .withString(GoldConstants.DETAIL_URL, data.getUrl())
                        .withString(GoldConstants.DETAIL_TITLE, data.getTitle())
                        .navigation(GoldHomeView.getActivity());
            }
        });
        return adapter;
    }
}

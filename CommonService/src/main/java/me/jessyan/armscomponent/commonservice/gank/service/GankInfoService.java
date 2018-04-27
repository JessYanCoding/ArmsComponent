package me.jessyan.armscomponent.commonservice.gank.service;

import com.alibaba.android.arouter.facade.template.IProvider;

import me.jessyan.armscomponent.commonservice.gank.bean.GankInfo;

/**
 * ================================================
 * Created by JessYan on 2018/4/27 14:16
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface GankInfoService extends IProvider {
    GankInfo getInfo();
}

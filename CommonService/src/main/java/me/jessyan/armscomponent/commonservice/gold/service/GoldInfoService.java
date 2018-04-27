package me.jessyan.armscomponent.commonservice.gold.service;

import com.alibaba.android.arouter.facade.template.IProvider;

import me.jessyan.armscomponent.commonservice.gold.bean.GoldInfo;

/**
 * ================================================
 * Created by JessYan on 2018/4/27 14:16
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface GoldInfoService extends IProvider {
    GoldInfo getInfo();
}

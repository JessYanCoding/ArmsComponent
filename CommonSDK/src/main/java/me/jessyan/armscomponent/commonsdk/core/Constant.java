package me.jessyan.armscomponent.commonsdk.core;

/**
 * ================================================
 * CommonSDK 的 Constant 可以定义公用的常量, 比如关于业务的常量或者正则表达式, 每个组件的 Constant 可以定义组件自己的私有常量
 *
 * Created by JessYan on 30/03/2018 17:32
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface Constant {
    //电话号码正则
    String PHONE_REGULAR = "^1[3-9]\\d{9}$";
}

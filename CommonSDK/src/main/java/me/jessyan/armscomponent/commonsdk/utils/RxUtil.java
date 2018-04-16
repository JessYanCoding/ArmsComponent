package me.jessyan.armscomponent.commonsdk.utils;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

/**
 * Created by ac on 2017/3/27.
 */

public class RxUtil {
    /**
     * 执行io线程  取消注册在io   回掉主线程
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> io_main() {
        return upstream -> upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * @param <T>
     * @return 重试次数
     */
    public static <T> ObservableTransformer<T, T> retry2() {
        return upstream -> upstream.retryWhen(new RetryWithDelay(2, 2));
    }


    /**
     * 都在io线程
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> all_io() {
        return upstream -> upstream
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io());
    }
}

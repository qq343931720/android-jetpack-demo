package in.zhiwei.jetpack.rxjava.op;

import android.util.Log;
import in.zhiwei.jetpack.rxjava.op.base.BaseOp;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Author: zhiwei.
 * Date: 2018/11/7 0007,20:15.
 */
public class OperateTimer extends BaseOp {

    private static String TAG = "OperateTimer";

    /*
     *  timer操作符，延迟指定时间，开始发送long类型的指令，类似于Interval.但是这发送一条
     */
    public static void doSome() {
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: " + d.isDisposed());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.w(TAG, "onNext: " + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete");
                    }
                });
    }

}

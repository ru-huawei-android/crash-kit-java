package com.sample.huawei.crash;

import android.app.Application;
import com.huawei.agconnect.crash.internal.AGConnectCrashHandler;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

public class CrashApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Change test api_key to yours key if needed
        YandexMetricaConfig config = YandexMetricaConfig.newConfigBuilder("b47641f9-8847-480d-8189-4d2b26d162d2").build();
        YandexMetrica.activate(getApplicationContext(), config);
        YandexMetrica.enableActivityAutoTracking(this);


        // For using huawei crash kit you should set handler explicitly
        // In other way if you're using, for example YandexMetric, YandexMetric will be the major one which catch your crashes
        // If you aren't using any of Metrics you haven't do anything for using huawei crash, only adding dependency in gradle
        Thread.setDefaultUncaughtExceptionHandler(AGConnectCrashHandler.getInstance());

    }
}


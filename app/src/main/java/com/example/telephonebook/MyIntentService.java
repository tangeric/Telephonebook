package com.example.telephonebook;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import org.litepal.LitePal;

public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("myintentservice");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String name=intent.getStringExtra("name");
        String number=intent.getStringExtra("number");
        Info info=new Info();
        info.setName(name);
        info.setNumber(number);
        info.save();
        Log.d("MyIntentService", "Handle方法执行了 ");
       Log.d("MyIntentService", name);
       Log.d("MyIntentService", number);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

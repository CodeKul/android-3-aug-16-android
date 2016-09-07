package com.codekul.andriod.comman;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

public class MyService extends Service {

    private MyImpl impl = new MyImpl();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this,"On bind", Toast.LENGTH_LONG).show();
        return impl;
    }

    public class MyImpl extends ICalc.Stub {
        @Override
        public int calculate(int num1, int num2) throws RemoteException {
            return num1+num2;
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this,"OnUnBind", Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }
}

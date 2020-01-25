package karangtaruna.wiranata.com.Utilities;

import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;

public abstract class OnOneClickListener implements View.OnClickListener {
    private static final long MIN_CLICK_INTERVAL = 700;
    private long lastClickTime = 0;

    @Override
    public final void onClick(View v){
        long currentTime = SystemClock.elapsedRealtime();
        if (currentTime - lastClickTime > MIN_CLICK_INTERVAL){
            if(WaitingList.waiting == false){
                WaitingList.waiting = true;
                lastClickTime = currentTime;
                onOneClick(v);
                new CountDownTimer(MIN_CLICK_INTERVAL,MIN_CLICK_INTERVAL){
                    @Override
                    public void onTick(long milisUntilFinished){

                    }
                    @Override
                    public void onFinish(){
                        WaitingList.waiting = false;
                    }
                }.start();
            }
        }
    }

    public abstract void onOneClick(View v);
}

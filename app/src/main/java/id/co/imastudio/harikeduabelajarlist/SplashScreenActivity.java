package id.co.imastudio.harikeduabelajarlist;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.wang.avi.AVLoadingIndicatorView;

public class SplashScreenActivity extends AppCompatActivity {

    AVLoadingIndicatorView avl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //buat ngilangin sinyal sm jam
        //JUGA BISA UNTUK NOTIF YANG MUNCUL SENDIRI
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        avl=(AVLoadingIndicatorView) findViewById(R.id.avloading);
        avl.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pindah=new Intent(SplashScreenActivity.this,MainActivity.class);
                startActivity(pindah);
                finish();  //untuk destroy page, sehingga di back tidak muncul lagi.
            }
        },3000);
    }
}

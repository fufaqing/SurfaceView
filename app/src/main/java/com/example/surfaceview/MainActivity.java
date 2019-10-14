package com.example.surfaceview;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.view.SurfaceView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private SurfaceView mainSfCamera;

    CameraSurfaceHolder mCameraSurfaceHolder = new CameraSurfaceHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainSfCamera = (SurfaceView) findViewById(R.id.main_sf_camera);

        // android 6.0以上动态申请权限  或targetSdkVersion设置为23以下

        if (checkCameraHardware(MainActivity.this)){
            mCameraSurfaceHolder.setCameraSurfaceHolder(this,mainSfCamera);
        }
    }

    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Toast.makeText(this, "搜索到摄像头硬件", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "不具备摄像头硬件", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}

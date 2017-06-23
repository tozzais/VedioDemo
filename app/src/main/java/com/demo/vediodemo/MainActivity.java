package com.demo.vediodemo;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    /**
     * 这是文件管理器下的绝对路径
     * 比如  Environment.getExternalStorageDirectory().getAbsolutePath()+“/test”
     *     就是文件管理器下的test文件夹
     */
    private String path = Environment.getExternalStorageDirectory().getAbsolutePath();
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.videoView);

        /**
         * 设置本地视频
         */
//        videoView.setVideoPath(path+"/DCIM/Camera/test2.mp4");
        /**
         * 设置网络路径
         */
        videoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));

        /**
         * 使用 MediaController 控制播放
         */
        MediaController mediaController = new MediaController(this);

        /**
         * 设置videoView 与MediaController建立关联
         */
        videoView.setMediaController(mediaController);
          /**
         * 设置 mediaController 与 VideoView 建立关联
         */
        mediaController.setMediaPlayer(videoView);



    }
}

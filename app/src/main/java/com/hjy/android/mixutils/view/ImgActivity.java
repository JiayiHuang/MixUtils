package com.hjy.android.mixutils.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.hjy.android.customwidget.R;

/**
 * Created by Hjy on 2016/9/21,16 o'clock
 */
public class ImgActivity extends Activity{
   private static final String TAG = "ImgActivity";

   public static void start(Activity activity) {
      Intent intent = new Intent(activity, ImgActivity.class);
      activity.startActivity(intent);
   }


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_img);

   }
}

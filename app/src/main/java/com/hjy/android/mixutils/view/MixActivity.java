package com.hjy.android.mixutils.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.hjy.android.mixutils.R;


/**
 * Created by Hjy on 2016/9/21,17 o'clock
 */
public class MixActivity extends Activity{
   public static void start(Activity activity){
      Intent intent = new Intent(activity, MixActivity.class);
      activity.startActivity(intent);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_view_mix);
   }
}

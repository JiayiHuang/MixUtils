package com.hjy.android.mixutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hjy.android.mixutils.view.ImgActivity;
import com.hjy.android.mixutils.view.MixActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
   private ListView listView;
   private ArrayList<String> itemLists = new ArrayList<>();
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      listView = (ListView) findViewById(R.id.listView);
      generateData();
      listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemLists));
      listView.setOnItemClickListener(this);
   }

   private void generateData() {
      itemLists.add("View-Image");
      itemLists.add("View-Mixed");
   }

   @Override
   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      switch (position){
         case 0:
            ImgActivity.start(this);
            break;
         case 1:
            MixActivity.start(this);
            break;
      }
   }
}

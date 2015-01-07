package com.pes.maikals.subscriptor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Domini.Val;
import ServiceLayer.ApiService;

import static android.R.layout.simple_list_item_1;


public class Vals extends Activity {
    private ArrayList<Val> vals;
    private String email;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vals);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        lv = (ListView) findViewById(R.id.listView);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        vals = ApiService.getVals(email);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vals, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();
        vals = ApiService.getVals(email);
        ArrayList<String> v = new ArrayList<String>();
        int n = vals.size();
        for (int i = 0; i < n; ++i) {
            v.add(vals.get(i).getNomSubscripcio());
        }
        lv = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, simple_list_item_1, v);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // selected item
                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                // sending data to new activity
                i.putExtra("id", ""+vals.get(position).getId());
                startActivity(i);

            }
        });
    }
}

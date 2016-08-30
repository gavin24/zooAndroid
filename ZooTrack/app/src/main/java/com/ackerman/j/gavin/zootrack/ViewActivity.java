package com.ackerman.j.gavin.zootrack;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.ackerman.j.gavin.zootrack.Domain.Animal;
import com.ackerman.j.gavin.zootrack.services.AnimalService;
import com.ackerman.j.gavin.zootrack.services.Impl.AnimalServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ViewActivity extends Activity {
    private AnimalServiceImpl activateService;
    private boolean isBound = false;
    private AnimalService activateAccountService;

    ListView listView ;
    Animal menuItem;
    List<Animal> menuItems;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listView = (ListView) findViewById(R.id.listView);


        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    AnimalServiceImpl service = new AnimalServiceImpl();
                    menuItems = service.findAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        try {
            thread.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        ArrayList<String> values = new ArrayList<String>();
        for(int x = 0 ;x < menuItems.size() ; x++)
        {
            values.add(menuItems.get(x).getName());
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                menuItem = menuItems.get(pos);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            AnimalServiceImpl service = new AnimalServiceImpl();
                            Animal ani = service.findById(menuItem.getId());
                            service.delete(ani);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                thread.start();

                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(),
                        menuItem.getName() + " Deleted", Toast.LENGTH_LONG)
                        .show();
                menuItems.remove(menuItem);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
                return true;
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                menuItem = menuItems.get(position);

                Toast.makeText(getApplicationContext(),
                        "Item ID :" + menuItem.getId() + "\n" +

                                "Name :" + menuItem.getName(), Toast.LENGTH_LONG)
                        .show();
            }

        });
    }


    public void homeClick(View v) {

        Intent i = new Intent(this,MenuActivity.class);

        startActivity(i);
    }

}

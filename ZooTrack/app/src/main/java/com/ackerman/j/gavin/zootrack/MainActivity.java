package com.ackerman.j.gavin.zootrack;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ackerman.j.gavin.zootrack.Domain.Animal;
import com.ackerman.j.gavin.zootrack.services.AnimalService;
import com.ackerman.j.gavin.zootrack.services.Impl.AnimalServiceImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // s.addAnimal();
    }

    public void onRegisterClick(View v) {

        Intent i = new Intent(this,RegisterActivity.class);

        startActivity(i);
    }
    public void onLoginClick(View v) {

        Intent i = new Intent(this,LoginActivity.class);

        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

}

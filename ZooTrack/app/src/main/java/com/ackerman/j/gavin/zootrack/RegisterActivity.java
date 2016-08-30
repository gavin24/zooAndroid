package com.ackerman.j.gavin.zootrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ackerman.j.gavin.zootrack.Domain.Animal;
import com.ackerman.j.gavin.zootrack.Domain.Employee;
import com.ackerman.j.gavin.zootrack.services.Impl.EmployeeServiceImpl;

/**
 * Created by gavin.ackerman on 2016-08-28.
 */
public class RegisterActivity extends AppCompatActivity {
    private EditText Name;
    private EditText passWord;
    private EditText Age;
    private EditText Country;
    private EditText Email;
    private EditText surName;
    private EmployeeServiceImpl employeeService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // s.addAnimal();
        Name = (EditText)findViewById(R.id.editTextName);
        surName = (EditText) findViewById(R.id.editTextSurname);
        Age = (EditText)findViewById(R.id.editTextAge);
        Country = (EditText) findViewById(R.id.editTextCountry);
        Email = (EditText)findViewById(R.id.editTextEmail);
        passWord = (EditText) findViewById(R.id.editTextPassword);
    }

    public void RegisterClick(View v) {
        if(Name == null || surName == null || Age == null || Country == null || Email == null || passWord == null) {
            Toast.makeText(getApplicationContext(),
                    "Please Fill in all fields", Toast.LENGTH_LONG)
                    .show();

        }
        else
        {
            employeeService = new EmployeeServiceImpl();
            String name = Name.getText().toString();
            String surname = surName.getText().toString();
            String email = Email.getText().toString();
            String password = passWord.getText().toString();
            String country = Country.getText().toString();
            int age =  Integer.parseInt(Age.getText().toString());
            Employee employee = new Employee.Builder()
                    .age(age)
                    .Country(country)
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .password(password)
                    .build();
            employeeService.save(employee);
            Intent i = new Intent(this,MenuActivity.class);

            startActivity(i);
        }

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

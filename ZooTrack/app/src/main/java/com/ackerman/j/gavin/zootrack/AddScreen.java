package com.ackerman.j.gavin.zootrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ackerman.j.gavin.zootrack.Domain.Animal;
import com.ackerman.j.gavin.zootrack.services.AnimalService;
import com.ackerman.j.gavin.zootrack.services.Impl.AnimalServiceImpl;

public class AddScreen extends AppCompatActivity {
    private AnimalServiceImpl activateService;
    EditText name,country,age,species;
    Intent t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);
        activateService = new AnimalServiceImpl();
        name = (EditText)findViewById(R.id.name);
        species = (EditText)findViewById(R.id.species);
        age = (EditText)findViewById(R.id.age);
        country = (EditText)findViewById(R.id.country);

    }

    public void onClick(View v) {

        String nameText = name.getText().toString();
        int ageText = Integer.parseInt(age.getText().toString());
        String speciesText = species.getText().toString();
        String countryText = country.getText().toString();


        Animal animal = new Animal.Builder()
                .age(ageText)
                .Country(countryText)
                .name(nameText)
                .species(speciesText)
                .build();


        activateService.save(animal);

        Intent intentLogin = new Intent(this, MenuActivity.class);
        startActivity(intentLogin);
        finish();
    }



}

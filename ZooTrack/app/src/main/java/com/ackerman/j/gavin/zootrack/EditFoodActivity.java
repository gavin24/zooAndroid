package com.ackerman.j.gavin.zootrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ackerman.j.gavin.zootrack.Domain.Animal;
import com.ackerman.j.gavin.zootrack.services.AnimalService;
import com.ackerman.j.gavin.zootrack.services.Impl.AnimalServiceImpl;

/**
 * Created by gavin.ackerman on 2016-08-28.
 */
public class EditFoodActivity extends AppCompatActivity {
    private AnimalServiceImpl activateService;
    private boolean isBound = false;
    private AnimalService activateAccountService;
    TextView name,country,age,species;
    Intent t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_animal_activity);
        Intent intent = new Intent(this, AnimalServiceImpl.class);


        activateService = new AnimalServiceImpl();
        name = (TextView)findViewById(R.id.name);
        species = (TextView)findViewById(R.id.species);
        age = (TextView)findViewById(R.id.age);
        country = (TextView)findViewById(R.id.country);

        String animalName = getIntent().getStringExtra("animalName");
        String animalCountry = getIntent().getStringExtra("animalCountry");
        String animalSpecies = getIntent().getStringExtra("animalSpecies");
        String animalAge = getIntent().getStringExtra("animalAge");

        name.setText(animalName);
        species.setText(animalSpecies);
        age.setText(animalAge);
        country.setText(animalCountry);

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

        Intent intentLogin = new Intent(this, ViewActivity.class);
        startActivity(intentLogin);
        finish();
    }
}

package com.example.projekt_dzienniktreningowy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    Button gotoCalendarButton;
    Button backDziennik;
    EditText serieET;
    EditText obciazenieET;
    AutoCompleteTextView autoCompleteTextView;
    Button addDziennik;

    private ArrayList<DataModel> dataModels;
    private static CustomAdapter adapter;

    private static final String[] CWICZENIA = new String[]{
            "PROSTOWANIE RAMION NA WYCIĄGU STOJĄC", "WYCISKANIE „FRANCUSKIE”SZTANGI W SIADZIE", "WYCISKANIE “FRANCUSKIE” JEDNORĄCZ SZTANGIELKI W SIADZIE", "WYCISKANIE „FRANCUSKIE” SZTANGI W LEŻENIU", "WYCISKANIE „FRANCUSKIE”SZTANGIELKI W LEŻENIU", "PROSTOWNIE RAMIENIA ZE SZTANGIELKĄ W OPADZIE TUŁOWIA", "PROSTOWANIE RAMION NA WYCIĄGU W PŁASZCZYŹNE POZIOMEJ STOJĄC", "POMPKI NA PORĘCZACH", "POMPKI W PODPORZE TYŁEM", "PROSTOWANIE RAMIENIA PODCHWYTEM NA WYCIĄGU STOJĄC", "WYCISKANIE W LEŻENIU NA ŁAWCE POZIOMEJ WĄSKIM UCHWYTEM"
            , "PODCIĄGANIE NA DRĄŻKU SZEROKIM UCHWYTEM (NACHWYT)", "PODCIĄGANIE NA DRĄŻKU PODCHWYTEM", "PODCIĄGANIE SZTANGI W OPADZIE (WIOSŁOWANIE)", "PODCIĄGANIE SZTANGIELKI W OPADZIE (WIOSŁOWANIE)", "PODCIĄGANIE KOŃCA SZTANGI W OPADZIE", "PRZYCIĄGANIE LINKI WYCIĄGU DOLNEGO W SIADZIE PŁASKIM", "PRZYCIĄGANIE LINKI WYCIĄGU GÓRNEGO W SIADZIE", "ŚCIĄGANIE DRĄŻKA WYCIĄGU GÓRNEGO W SIADZIE SZEROKIM UCHWYTEM (NACHWYT)", "ŚCIĄGANIE DRĄŻKA WYCIĄGU GÓRNEGO W SIADZIE PODCHWYTEM", "ŚCIĄGANIE DRĄŻKA WYCIĄGU GÓRNEGO W SIADZIE UCHWYT NEUTRALNY", "PODCIĄGANIE (WIOSŁOWANIE) W LEŻENIU NA ŁAWECZCE POZIOMEJ", "SKŁONY ZE SZTANGĄ TRZYMANĄ NA KARKU (TZW. 'DZIEŃ DOBRY')", "UNOSZENIE TUŁOWIA Z OPADU", "MARTWY CIĄG", "MARTWY CIAG NA PROSTYCH NOGACH", "WZNOSY BARKÓW 'SZRUGSY'"
            , "PRZYSIADY ZE SZTANGĄ NA BARKACH", "PRZYSIADY ZE SZTANGĄ TRZYMANĄ Z PRZODU", "HACK-PRZYSIADY", "PRZYSIADY NA SUWNICY SKOŚNEJ (HACK-MASZYNIE)", "SYZYFKI", "PROSTOWNIE NÓG W SIADZIE", "WYPYCHANIE CIĘŻARU NA SUWNICY (MASZYNIE)", "UGINANIE NÓG W LEŻENIU", "PRZYSIADY WYKROCZNE", "NOŻYCE", "WYSOKI STEP ZA SZTANGĄ/SZTANGIELKAMI", "ODWODZENIE NOGI W TYŁ", "PRZYWODZENIE NÓG DO WEWNĄTRZ", "ODWODZENIE NÓG NA ZEWNĄTRZ", "”MARTWY CIĄG”NA PROSTYCH NOGACH", "WSPIECIA NA PALCE W STANIU", "OŚLE WSPIĘCIA", "WYPYCHANIE CIĘŻARU NA MASZYNIE/SUWNICY PALCAMI NÓG"
            , "WYCISKANIE SZTANGI W LEŻENIU NA ŁAWCE POZIOMEJ", "WYCISKANIE SZTANGIELEK W LEŻENIU NA ŁAWCE POZIOMEJ", "WYCISKANIE SZTANGI W LEŻENIU NA ŁAWCE SKOŚNEJ-GŁOWĄ  W GÓRĘ", "WYCISKANIE SZTANGIELEK W LEŻENIU NA ŁAWCE SKOŚNEJ - GŁOWĄ W GÓRĘ", "ROZPIĘTKI ZE SZTANGIELKAMI W LEŻENIU NA ŁAWCE POZIOMEJ", "POMPKI NA PORĘCZACH", "ROZPIĘTKI W SIADZIE NA MASZYNIE", "KRZYŻOWANIE LINEK WYCIĄGU W STANIU", "WYCISKANIA POZIOME W SIADZIE NA MASZYNIE"
            , "SKŁONY W LEŻENIU PŁASKO", "SKŁONY TUŁOWIA Z LINKĄ WYCIĄGU SIEDZĄC", "SKRĘTY TUŁOWIA", "SKŁONY TUŁOWIA Z LINKĄ WYCIĄGU KLĘCZĄC", "SKŁONY BOCZNE", "SKRĘTY TUŁOWIA W LEŻENIU"
            , "UGINANIE RAMION ZE SZTANGĄ STOJAC PODCHWYTEM", "UGINANIE RAMION ZE SZTANGIELKAMI STOJĄC PODCHWYTEM (Z 'SUPINACJĄ' NADGARSTKA)", "UGINANIE RAMION ZE SZTANGIELKAMI STOJĄC (UCHWYT 'MŁOTKOWY')", "UGINANIE RAMION ZE SZTANGĄ NA 'MODLITEWNIKU'", "UGINANIE RAMION ZE SZTANGIELKAMI W SIADZIE NA ŁAWCE SKOŚNEJ (Z SUPINACJĄ NADGARSTKA)", "UGINANIE RAMIENIA ZE SZTANGIELKĄ W SIADZIE - W PODPORZE O KOLANO", "UGINANIE RAMION PODCHWYTEM STOJĄC - Z RĄCZKĄ WYCIĄGU", "UGINANIE NADGARSTKÓW PODCHWYTEM W SIADZIE", "UGINANIE NADGARSTKÓW NACHWYTEM W SIADZIE"
            , "WYCISKANIE SZTANGI SPRZED GŁOWY", "WYCISKANIE SZTANGI ZZA GŁOWY", "Wyciskanie sztangielek", "Arnoldki-inna odmiana ćwiczenia", "Unoszenie sztangielek bokiem w górę", "Unoszenie sztangielek w opadzie tułowia", "Podciąganie sztangi wzdłuż tułowia", "Unoszenie ramion w przód ze sztangą", "Unoszenie ramion w przód ze sztangielkami", "Unoszenie ramion ze sztangielkami w leżeniu", "Unoszenie ramion w przód z linkami wyciągu", "Unoszenie ramion bokiem w górę z linkami wyciągu", "Unoszenie ramion bokiem w górę w opadzie tułowia z linkami wyciągu", "Odwrotne rozpiętki (na maszynie)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_add);

        loadData();

        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");

        autoCompleteTextView = findViewById(R.id.NazwaCwiczeniaACTV);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CWICZENIA);
        autoCompleteTextView.setAdapter(adapter);

        obciazenieET = findViewById(R.id.ObciazenieET);
        serieET = findViewById(R.id.SerieET);

        gotoCalendarButton = findViewById(R.id.GoToCalendarButton);
        gotoCalendarButton.setText(date);
        gotoCalendarButton.setOnClickListener(this);

        addDziennik = findViewById(R.id.addDziennik);
        addDziennik.setOnClickListener(this);

        backDziennik = findViewById(R.id.backDziennik);
        backDziennik.setOnClickListener(this);

        if (dataModels == null) {
            dataModels = new ArrayList<>();
        }

        if (savedInstanceState != null) {
            String myCwiczenie = savedInstanceState.getString("myCwiczenie");
            String myData = savedInstanceState.getString("myData");
            String myObciazenie = savedInstanceState.getString("myObciazenie");
            String mySerie = savedInstanceState.getString("mySerie");

            gotoCalendarButton.setText(myData);
            autoCompleteTextView.setText(myCwiczenie);
            serieET.setText(mySerie);
            obciazenieET.setText(myObciazenie);
        }
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Cwiczenia", null);
        Type type = new TypeToken<ArrayList<DataModel>>() {
        }.getType();
        dataModels = gson.fromJson(json, type);
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(dataModels);
        editor.putString("Cwiczenia", json);
        editor.apply();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addDziennik:
                String cwiczenieWprowadzone = autoCompleteTextView.getText().toString();
                String dataWprowadzone = gotoCalendarButton.getText().toString();
                String obciazenieWprowadzone = obciazenieET.getText().toString();
                String serieWprowadzone = serieET.getText().toString();

                if (cwiczenieWprowadzone.isEmpty()) {
                    autoCompleteTextView.setError("Pole jest puste");
                    autoCompleteTextView.requestFocus();
                    return;
                }

                if (dataWprowadzone.isEmpty()) {
                    gotoCalendarButton.setError("Nie wybrano daty");
                    gotoCalendarButton.requestFocus();
                    return;
                }

                if (obciazenieWprowadzone.isEmpty()) {
                    obciazenieET.setError("Pole jest puste");
                    obciazenieET.requestFocus();
                    return;
                }

                if (serieWprowadzone.isEmpty()) {
                    serieET.setError("Pole jest puste");
                    serieET.requestFocus();
                    return;
                }

                dataModels.add(0, new DataModel(cwiczenieWprowadzone, dataWprowadzone, obciazenieWprowadzone, serieWprowadzone));

                autoCompleteTextView.setText("");
                gotoCalendarButton.setText("");
                obciazenieET.setText("");
                serieET.setText("");

                Toast.makeText(this, "Dodano do dziennika", Toast.LENGTH_SHORT).show();
                saveData();

                Intent addedintent = new Intent(this, MainActivity.class);
                startActivity(addedintent);
                break;

            case R.id.GoToCalendarButton:
                Intent intentCalendar = new Intent(AddActivity.this, CalendarActivity.class);
                startActivity(intentCalendar);
                break;

            case R.id.backDziennik:
                Intent intentDziennik = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intentDziennik);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("myCwiczenie", autoCompleteTextView.getText().toString());
        outState.putString("myData", gotoCalendarButton.getText().toString());
        outState.putString("myObciazenie", obciazenieET.getText().toString());
        outState.putString("mySerie", serieET.getText().toString());
    }

//
}

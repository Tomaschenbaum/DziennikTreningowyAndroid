package com.example.projekt_dzienniktreningowy;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> dataModels;
    private static CustomAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.items_list);

        loadData();

        adapter = new CustomAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Usunąć?");
                adb.setMessage("Czy na pewno chcesz usunąć ten element?");
                final int positionToRemove = position;
                adb.setNegativeButton("Anuluj", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dataModels.remove(positionToRemove);
                        adapter.notifyDataSetChanged();
                        saveData();
                    }
                });
                adb.show();
            }
        });
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Cwiczenia", null);
        System.out.println(json);
        Type type = new TypeToken<ArrayList<DataModel>>() {
        }.getType();
        dataModels = gson.fromJson(json, type);

        if (dataModels == null) {
            dataModels = new ArrayList<>();
        }
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(dataModels);
        editor.putString("Cwiczenia", json);
        editor.apply();
    }

    public void goToAtlasActivity(View view) {
        Intent intent = new Intent(this, AtlasActivity.class);
        startActivity(intent);
    }

    public void goToAddActivity(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    public void goToProgressActivity(View view) {
        Intent intent = new Intent(this, ProgressActivity.class);
        startActivity(intent);
    }
}

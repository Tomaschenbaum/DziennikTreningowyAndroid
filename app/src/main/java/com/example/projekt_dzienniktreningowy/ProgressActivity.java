package com.example.projekt_dzienniktreningowy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ProgressActivity extends AppCompatActivity {
    JSONArray root;
    LayoutInflater layoutInflator;
    private ArrayList<ProgressDataModel> dataModel;
    private static ProgressCustomAdapter adapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_progress);

        dataModel = new ArrayList<>();

        listView = findViewById(R.id.progress_list);

        loadData();
        adapter = new ProgressCustomAdapter(dataModel, getApplicationContext());

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        try {
            System.out.println(root.getJSONObject(0).getString("obciazenie"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        String json = sharedPreferences.getString("Cwiczenia", null);

        try {
            root = new JSONArray(json);
            JSONArray sortedJsonArray = new JSONArray();

            sortArray(sortedJsonArray, root);
            Multimap<String, String> multiMap = ArrayListMultimap.create();

            for(int i = 0; i<sortedJsonArray.length(); i++)
            {
                multiMap.put(sortedJsonArray.getJSONObject(i).getString("cwiczenie"),
                        sortedJsonArray.getJSONObject(i).getString("obciazenie"));
            }

            layoutInflator = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

            List views = new ArrayList();

            Set<String> keys = multiMap.keySet();
            for (String key : keys) {
                //Log.i("test1", "Key = " + key);
                //Log.i("test2", "Values = " + multiMap.get(key) + "n");
                List<String> test = (List) multiMap.get(key);
                Collections.sort(test);
                int min = Integer.parseInt(test.get(0));
                int max = Integer.parseInt(test.get(test.size()-1));
                Integer sum = 0;
                for(String val : test)
                    sum += Integer.parseInt(val);
                //int sum = test.stream().mapToInt(Integer::intValue).sum(); need API 24 ?
                double srednia = sum/test.size();
                Log.i("Cwiczenie", key);
                Log.i("min", String.valueOf(min));
                Log.i("max", String.valueOf(max));
                Log.i("sum", String.valueOf(sum));
                Log.i("srednia", String.valueOf(srednia));

                dataModel.add(0, new ProgressDataModel(key, String.valueOf(srednia), String.valueOf(max), String.valueOf(min)));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void sortArray(JSONArray sortedJsonArray, JSONArray rawJsonArray) throws JSONException {
        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < rawJsonArray.length(); i++) {
            jsonValues.add(rawJsonArray.getJSONObject(i));
        }
        Collections.sort( jsonValues, new Comparator<JSONObject>() {
            private static final String KEY_NAME = "cwiczenie";

            @Override
            public int compare(JSONObject a, JSONObject b) {
                String valA = new String();
                String valB = new String();

                try {
                    valA = (String) a.get(KEY_NAME);
                    valB = (String) b.get(KEY_NAME);
                }
                catch (JSONException e) {

                }
                return valA.compareTo(valB);
            }
        });

        for (int i = 0; i < rawJsonArray.length(); i++) {
            sortedJsonArray.put(jsonValues.get(i));
        }
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToAtlasActivity(View view) {
        Intent intent = new Intent(this, AtlasActivity.class);
        startActivity(intent);
    }
}


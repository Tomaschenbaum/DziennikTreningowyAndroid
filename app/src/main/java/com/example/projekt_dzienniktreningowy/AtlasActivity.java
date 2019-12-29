package com.example.projekt_dzienniktreningowy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AtlasActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_atlas);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                final String selected = (String) expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition);

                switch (selected) {
                    case "SKŁONY W LEŻENIU PŁASKO":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Atl6nfJGRhg")));
                        break;
                    case "SKŁONY TUŁOWIA Z LINKĄ WYCIĄGU SIEDZĄC":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ufOw92cUjqg")));
                        break;
                    case "SKRĘTY TUŁOWIA":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/8U6qOXjaYTM")));
                        break;
                    case "SKŁONY TUŁOWIA Z LINKĄ WYCIĄGU KLĘCZĄC":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/8U6qOXjaYTM")));
                        break;
                    case "SKŁONY BOCZNE":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/AAQRVXSHlbs")));
                        break;
                    case "SKRĘTY TUŁOWIA W LEŻENIU":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Atl6nfJGRhg")));
                        break;
                    case "WYCISKANIE SZTANGI W LEŻENIU NA ŁAWCE POZIOMEJ":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/9n4lgCrxr0I")));
                        break;
                    case "WYCISKANIE SZTANGIELEK W LEŻENIU NA ŁAWCE POZIOMEJ":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/P1Qv-oXczxs")));
                        break;
                    case "WYCISKANIE SZTANGI W LEŻENIU NA ŁAWCE SKOŚNEJ - GŁOWĄ W GÓRĘ":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/voKocA7kblo")));
                        break;
                    case "WYCISKANIE SZTANGIELEK W LEŻENIU NA ŁAWCE SKOŚNEJ - GŁOWĄ W GÓRĘ":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/0gPt--vcoW4")));
                        break;
                    case "ROZPIĘTKI ZE SZTANGIELKAMI W LEŻENIU NA ŁAWCE POZIOMEJ":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/pzb2P55g8vc")));
                        break;
                    case "POMPKI NA PORĘCZACH":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/WjHOdq4MAJA")));
                        break;
                    case "ROZPIĘTKI W SIADZIE NA MASZYNIE":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/vSwGglMtDhs")));
                        break;
                    case "KRZYŻOWANIE LINEK WYCIĄGU W STANIU":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/LHO_eNwI9Bc")));
                        break;
                    case "SWYCISKANIA POZIOME W SIADZIE NA MASZYNIE":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/DgasTNLyQcg")));
                        break;
                    case "PODCIĄGANIE NA DRĄŻKU SZEROKIM UCHWYTEM (NACHWYT)":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/X5eptRVZUno")));
                        break;
                    case "PODCIĄGANIE NA DRĄŻKU PODCHWYTEM":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HkZH3rgnTUo")));
                        break;
                    case "PODCIĄGANIE SZTANGI W OPADZIE (WIOSŁOWANIE)":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/PaqvesLOcpA")));
                        break;
                    case "PODCIĄGANIE SZTANGIELKI W OPADZIE (WIOSŁOWANIE)":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/zTEXQ4WH7oY")));
                        break;
                    case "PODCIĄGANIE KOŃCA SZTANGI W OPADZIE":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/-XD4HXqqdNY")));
                        break;
                    case "PRZYCIĄGANIE LINKI WYCIĄGU DOLNEGO W SIADZIE PŁASKIM":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/XOoFudeINrw")));
                        break;
                    case "PRZYCIĄGANIE LINKI WYCIĄGU GÓRNEGO W SIADZIE":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/A6_aGkGx5Z8")));
                        break;
                    case "UGINANIE RAMION ZE SZTANGĄ STOJAC PODCHWYTEM":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/415ZedAmmGg")));
                        break;
                    case "UGINANIE RAMION ZE SZTANGIELKAMI STOJĄC PODCHWYTEM (Z 'SUPINACJĄ' NADGARSTKA)":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/1IdQyaVmCMo")));
                        break;
                    case "UGINANIE RAMION ZE SZTANGIELKAMI STOJĄC (UCHWYT 'MŁOTKOWY')":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HTcXehjywD0")));
                        break;
                    case "UGINANIE RAMION ZE SZTANGĄ NA 'MODLITEWNIKU'":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/BPxCVAz0gbA")));
                        break;
                    case "UGINANIE RAMION ZE SZTANGIELKAMI W SIADZIE NA ŁAWCE SKOŚNEJ (Z SUPINACJĄ NADGARSTKA)":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/DtFXk_lPJig")));
                        break;
                    case "UGINANIE RAMIENIA ZE SZTANGIELKĄ W SIADZIE - W PODPORZE O KOLANO":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/kt63lmiVck0")));
                        break;
                    case "WYCISKANIE SZTANGI SPRZED GŁOWY":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/BclIGnkgZVc")));
                        break;
                    case "WYCISAKNIE SZTANGI ZZA GŁOWY":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/0uG8lIiAPpY")));
                        break;
                    case "WYCISKANIE SZTANGIELEK":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/XhCtAly3Kj0")));
                        break;
                    case "ARNOLDKI - INNA ODMIANA ĆWICZENIA":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/5qDTijyAJ_U")));
                        break;
                    case "UNOSZENIE SZTAGIELEK BOKIEM W GÓRĘ":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/NBLs0ksPczQ")));
                        break;
                    case "UNOSZENIE SZTAGIELEK W OPADZIE TUŁOWIA":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/UJN3gVIvNk4")));
                        break;
                    case "PODCIĄGANIE SZTANGI WZDŁUŻ TŁOWIA":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/-ftuEtCpZEc")));
                        break;
                    case "PROSTOWANIE RAMION NA WYCIĄGU STOJĄC":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/rR8CZHw8kTw")));
                        break;
                    case "WYCISKANIE „FRANCUSKIE”SZTANGI W SIADZIE":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/lRJz0tqLlpk")));
                        break;
                    case "WYCISKANIE “FRANCUSKIE” JEDNORĄCZ SZTANGIELKI W SIADZIE":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/rR8CZHw8kTw")));
                        break;
                    case "WYCISKANIE „FRANCUSKIE” SZTANGI W LEŻENIU":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/nYO5EcbaDos")));
                        break;
                    case "WYCISKANIE „FRANCUSKIE”SZTANGIELKI W LEŻENIU":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Esn3Yz2Xqr8")));
                        break;
                    case "PROSTOWNIE RAMIENIA ZE SZTANGIELKĄ W OPADZIE TUŁOWIA":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/j5QxEPkEJGA")));
                        break;
                    case "PROSTOWANIE RAMION NA WYCIĄGU W PŁASZCZYŹNE POZIOMEJ STOJĄC":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/T3ltIn0YH6E")));
                        break;
                    case "POMPKI W PODPORZE TYŁEM":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/DtpGS3tJlbs")));
                        break;
                    case "PROSTOWANIE RAMIENIA PODCHWYTEM NA WYCIĄGU STOJĄC":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/-tz21fvWd6A")));
                        break;
                    case "PRZYSIADY ZE SZTANGĄ NA BARKACH":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/nnk9KItK938")));
                        break;
                    case "PRZYSIADY ZE SZTANGĄ TRZYMANĄ Z PRZODU":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/rdCcNWe7j1s")));
                        break;
                    case "HACK-PRZYSIADY":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/8U2_8ye8lmQ")));
                        break;
                    case "PRZYSIADY NA SUWNICY SKOŚNEJ (HACK-MASZYNIE)":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/RJ4u3rJxE8g")));
                        break;
                    case "SYZYFKI":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/D-aftlXh7tE")));
                        break;
                    case "PROSTOWNIE NÓG W SIADZIE":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/zmpFEl7NFG0")));
                        break;
                    case "WYPYCHANIE CIĘŻARU NA SUWNICY (MASZYNIE)":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HIAWxO-NPpA")));
                        break;
                    case "UGINANIE NÓG W LEŻENIU":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/KC4clTFYqEk")));
                        break;
                    case "PRZYSIADY WYKROCZNE":
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/fqymGym7YL0")));
                        break;
                }

                return false;
            }
        });
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToProgressActivity(View view) {
        Intent intent = new Intent(this, ProgressActivity.class);
        startActivity(intent);
    }
}

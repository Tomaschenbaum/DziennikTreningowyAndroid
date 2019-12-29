package com.example.projekt_dzienniktreningowy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> klatka = new ArrayList<String>();
        klatka.add("WYCISKANIE SZTANGI W LEŻENIU NA ŁAWCE POZIOMEJ");
        klatka.add("WYCISKANIE SZTANGIELEK W LEŻENIU NA ŁAWCE POZIOMEJ");
        klatka.add("WYCISKANIE SZTANGI W LEŻENIU NA ŁAWCE SKOŚNEJ - GŁOWĄ  W GÓRĘ");
        klatka.add("WYCISKANIE SZTANGIELEK W LEŻENIU NA ŁAWCE SKOŚNEJ - GŁOWĄ W GÓRĘ");
        klatka.add("ROZPIĘTKI ZE SZTANGIELKAMI W LEŻENIU NA ŁAWCE POZIOMEJ");
        klatka.add("POMPKI NA PORĘCZACH");
        klatka.add("ROZPIĘTKI W SIADZIE NA MASZYNIE");
        klatka.add("KRZYŻOWANIE LINEK WYCIĄGU W STANIU");
        klatka.add("WYCISKANIA POZIOME W SIADZIE NA MASZYNIE");

        List<String> plecy = new ArrayList<String>();
        plecy.add("PODCIĄGANIE NA DRĄŻKU SZEROKIM UCHWYTEM (NACHWYT)");
        plecy.add("PODCIĄGANIE NA DRĄŻKU PODCHWYTEM");
        plecy.add("PODCIĄGANIE SZTANGI W OPADZIE (WIOSŁOWANIE)");
        plecy.add("PODCIĄGANIE SZTANGIELKI W OPADZIE (WIOSŁOWANIE)");
        plecy.add("PODCIĄGANIE KOŃCA SZTANGI W OPADZIE");
        plecy.add("PRZYCIĄGANIE LINKI WYCIĄGU DOLNEGO W SIADZIE PŁASKIM");
        plecy.add("PRZYCIĄGANIE LINKI WYCIĄGU GÓRNEGO W SIADZIE");

        List<String> barki = new ArrayList<String>();
        barki.add("WYCISKANIE SZTANGI SPRZED GŁOWY");
        barki.add("WYCISAKNIE SZTANGI ZZA GŁOWY");
        barki.add("WYCISKANIE SZTANGIELEK");
        barki.add("ARNOLDKI - INNA ODMIANA ĆWICZENIA");
        barki.add("UNOSZENIE SZTAGIELEK BOKIEM W GÓRĘ");
        barki.add("UNOSZENIE SZTAGIELEK W OPADZIE TUŁOWIA");
        barki.add("PODCIĄGANIE SZTANGI WZDŁUŻ TŁOWIA");

        List<String> biceps = new ArrayList<String>();
        biceps.add("UGINANIE RAMION ZE SZTANGĄ STOJAC PODCHWYTEM");
        biceps.add("UGINANIE RAMION ZE SZTANGIELKAMI STOJĄC PODCHWYTEM (Z 'SUPINACJĄ' NADGARSTKA)");
        biceps.add("UGINANIE RAMION ZE SZTANGIELKAMI STOJĄC (UCHWYT 'MŁOTKOWY')");
        biceps.add("UGINANIE RAMION ZE SZTANGĄ NA 'MODLITEWNIKU'");
        biceps.add("UGINANIE RAMION ZE SZTANGIELKAMI W SIADZIE NA ŁAWCE SKOŚNEJ (Z SUPINACJĄ NADGARSTKA)");
        biceps.add("UGINANIE RAMIENIA ZE SZTANGIELKĄ W SIADZIE - W PODPORZE O KOLANO");

        List<String> triceps = new ArrayList<String>();
        triceps.add("PROSTOWANIE RAMION NA WYCIĄGU STOJĄC");
        triceps.add("WYCISKANIE „FRANCUSKIE”SZTANGI W SIADZIE");
        triceps.add("WYCISKANIE “FRANCUSKIE” JEDNORĄCZ SZTANGIELKI W SIADZIE");
        triceps.add("WYCISKANIE „FRANCUSKIE” SZTANGI W LEŻENIU");
        triceps.add("WYCISKANIE „FRANCUSKIE”SZTANGIELKI W LEŻENIU");
        triceps.add("PROSTOWNIE RAMIENIA ZE SZTANGIELKĄ W OPADZIE TUŁOWIA");
        triceps.add("PROSTOWANIE RAMION NA WYCIĄGU W PŁASZCZYŹNE POZIOMEJ STOJĄC");
        triceps.add("POMPKI NA PORĘCZACH");
        triceps.add("POMPKI W PODPORZE TYŁEM");
        triceps.add("PROSTOWANIE RAMIENIA PODCHWYTEM NA WYCIĄGU STOJĄC");

        List<String> nogi = new ArrayList<String>();
        nogi.add("PRZYSIADY ZE SZTANGĄ NA BARKACH");
        nogi.add("PRZYSIADY ZE SZTANGĄ TRZYMANĄ Z PRZODU");
        nogi.add("HACK-PRZYSIADY");
        nogi.add("PRZYSIADY NA SUWNICY SKOŚNEJ (HACK-MASZYNIE)");
        nogi.add("SYZYFKI");
        nogi.add("PROSTOWNIE NÓG W SIADZIE");
        nogi.add("WYPYCHANIE CIĘŻARU NA SUWNICY (MASZYNIE)");
        nogi.add("UGINANIE NÓG W LEŻENIU");
        nogi.add("PRZYSIADY WYKROCZNE");

        List<String> brzuch = new ArrayList<String>();
        brzuch.add("SKŁONY W LEŻENIU PŁASKO");
        brzuch.add("SKŁONY TUŁOWIA Z LINKĄ WYCIĄGU SIEDZĄC");
        brzuch.add("SKRĘTY TUŁOWIA");
        brzuch.add("SKŁONY TUŁOWIA Z LINKĄ WYCIĄGU KLĘCZĄC");
        brzuch.add("SKŁONY BOCZNE");
        brzuch.add("SKRĘTY TUŁOWIA W LEŻENIU");

        expandableListDetail.put("KLATKA PIERSIOWA", klatka);
        expandableListDetail.put("PLECY", plecy);
        expandableListDetail.put("BARKI", barki);
        expandableListDetail.put("BICEPS", biceps);
        expandableListDetail.put("TRICEPS", triceps);
        expandableListDetail.put("NOGI", nogi);
        expandableListDetail.put("BRZUCH", brzuch);
        return expandableListDetail;
    }
}



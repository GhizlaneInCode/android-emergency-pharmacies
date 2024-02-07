package com.example.pharmacie1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Pharmacie_Adapter adapter;
    ArrayList<Pharmacie> pharmacies;
    Button button;
    //ArrayList<String> namestab = new ArrayList<>();
    //ArrayList<String> addresstab = new ArrayList<>();
    //ArrayList<String> teltab = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pharmacies = new ArrayList<>();
        adapter = new Pharmacie_Adapter(this, pharmacies);
        button = findViewById(R.id.button);

        SliderView sliderView = findViewById(R.id.imageSlider);

        SliderAdapterExample adapter = new SliderAdapterExample(this);
        SliderItem item1 = new SliderItem(null,"https://img.freepik.com/free-psd/medical-capsules-mock-up-top-view_23-2148478002.jpg?w=1060&t=st=1658940805~exp=1658941405~hmac=102642daef9d54a3b7f5d6d5de1a2779b054dcb14915d669965f57948bd7895d");
        SliderItem item2 = new SliderItem(null,"https://img.freepik.com/free-vector/pharmaceutical-medicine-healthcare-template-vector-presentation_53876-117796.jpg?w=1380&t=st=1658939849~exp=1658940449~hmac=4c18f89b77d435ca8d0e768230994e37636640ab4149cab407e70a6b6dc3dab1");
        SliderItem item3 = new SliderItem(null,"https://img.freepik.com/free-vector/healthcare-background-with-medical-symbols-hexagonal-frame_1017-26363.jpg?w=1380&t=st=1658940764~exp=1658941364~hmac=a935153f45d94f5a740556029f388c4d592d5edc0df3aaf5fde66d410987102f");
        SliderItem item4 = new SliderItem(null,"https://img.freepik.com/free-psd/medical-mock-up-with-capsules_23-2148478001.jpg?w=1060&t=st=1658940749~exp=1658941349~hmac=ee30bfdb8673ff5c626c7e84c67a55ad4c84b35e349a83e3c9c73f162f7d2fef");
        List<SliderItem> ls = new ArrayList<>();
        ls.add(item1);
        ls.add(item2);
        ls.add(item3);
        ls.add(item4);
        adapter.renewItems(ls);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        button.setOnClickListener(v -> {

            Intent intent = new Intent(this, pharmacyActivity.class);
            startActivity(intent);
        });
/*
        button.setOnClickListener(v -> {
            try {
                Document document = Jsoup.connect("https://www.med.tn/pharmacie-maroc/fes")
                        .userAgent("Mozilla")
                        .header("Accept", "text/html")
                        .header("Accept-Encoding", "gzip,deflate")
                        .header("Accept-Language", "it-IT,en;q=0.8,en-US;q=0.6,de;q=0.4,it;q=0.2,es;q=0.2")
                        .header("Connection", "keep-alive")
                        .ignoreContentType(true).
                                get();
                Elements names = document.getElementsByClass("list__label--name");
                for (Element name : names)
                    namestab.add(name.text());

                Elements addrs = document.getElementsByClass("list__label--adr");
                for (Element adress : addrs)
                    addresstab.add(adress.ownText());

                Elements tels = document.getElementsByClass("calltel");
                for (Element tel : tels)
                    teltab.add(tel.ownText());

                Document document2 = Jsoup.connect("https://www.med.tn/pharmacie-maroc/fes/1")
                        .userAgent("Mozilla")
                        .header("Accept", "text/html")
                        .header("Accept-Encoding", "gzip,deflate")
                        .header("Accept-Language", "it-IT,en;q=0.8,en-US;q=0.6,de;q=0.4,it;q=0.2,es;q=0.2")
                        .header("Connection", "keep-alive")
                        .ignoreContentType(true).
                                get();
                Elements names2 = document2.getElementsByClass("list__label--name");
                for (Element name : names2)
                    namestab.add(name.text());

                Elements addrs2 = document2.getElementsByClass("list__label--adr");
                for (Element adress : addrs2)
                    addresstab.add(adress.ownText());

                Elements tels2 = document2.getElementsByClass("calltel");
                for (Element tel : tels2)
                    teltab.add(tel.ownText());


            } catch (
                    IOException e) {
                e.printStackTrace();
            }


            System.out.println("name" + namestab.size());
            System.out.println("addr" + addresstab.size());
            System.out.println("tel" + teltab.size());


            for (int i = 0; i < namestab.size(); i++) {
                pharmacies.add(new Pharmacie(namestab.get(i), addresstab.get(i), teltab.get(i)));
                adapter.notifyDataSetChanged();
            }


            for (Pharmacie e : pharmacies) {
                System.out.println(e.toString());
            }

        });
    */

    }

}
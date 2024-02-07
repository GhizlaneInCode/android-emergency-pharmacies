package com.example.pharmacie1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class pharmacyActivity extends AppCompatActivity {

    RecyclerView rv;
    Pharmacie_Adapter adapter;
    ArrayList<Pharmacie> pharmacies;
    Button buttonShow;
    ArrayList<String> namestab = new ArrayList<>();
    ArrayList<String> addresstab = new ArrayList<>();
    ArrayList<String> teltab = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);


            rv = findViewById(R.id.rv);
            pharmacies = new ArrayList<>();
            adapter = new Pharmacie_Adapter(this, pharmacies);
            rv.setLayoutManager(new GridLayoutManager(this, 1));
            rv.setAdapter(adapter);
        buttonShow = findViewById(R.id.buttonShow);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);

        buttonShow.setOnClickListener(v -> {


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


        }
    }

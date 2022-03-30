package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Env_Certicate.Env_CertificateActivity;
import com.example.myapplication.Product.Product;
import com.example.myapplication.Product.Product_FirebaseAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Write a message to the database

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    //Firebase init
    RecyclerView recyclerView;
    Product_FirebaseAdapter adapter;


    Button goToCertificate;

    //init tab
    MyPagerAdapter myPagerAdapter;
    TabLayout tabLayout;
    TabItem main,search,favs,basket,compare;

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRef.setValue("Hello, World!");



        tabLayout=findViewById(R.id.tabLayout);
        main=findViewById(R.id.main);
        search=findViewById(R.id.search);
        favs=findViewById(R.id.favs);
        basket=findViewById(R.id.basket);
        compare=findViewById(R.id.compare);
        viewPager=findViewById(R.id.viewPager);

        myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(myPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//
//        Product p=new Product();
//        p.setName("Ariel");
//        p.setScore(8);
//        p.setEnv_Certicates(new ArrayList<>());
//        p.setImagePath("https://firebasestorage.googleapis.com/v0/b/environment-546d0.appspot.com/o/769104721_tn24_0.jpg?alt=media&token=fcbd9419-9971-41ce-a282-f318cdb495f6");
//        DatabaseReference productRef= database.getReference("Products");
//        productRef.child(p.getId()).setValue(p);

        //
//        FirebaseRecyclerOptions<Product> options =
//                new FirebaseRecyclerOptions.Builder<Product>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Products"), Product.class)
//                        .build();
//
//        adapter=new Product_FirebaseAdapter(options);
//        recyclerView=findViewById(R.id.products_recycler_view);
//        adapter.startListening();
//        recyclerView.setAdapter(adapter);
//
//        LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
//
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        goToCertificate=findViewById(R.id.goToCertificates);
//        goToCertificate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(getApplicationContext(), Env_CertificateActivity.class);
//                startActivity(intent);
//            }
//        });
       //End of on Create
    }
}
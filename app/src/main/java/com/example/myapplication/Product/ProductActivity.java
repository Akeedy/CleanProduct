package com.example.myapplication.Product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Env_Certicate.Env_Certificate;
import com.example.myapplication.Env_Certicate.Env_Certificate_FirebaseAdapter;
import com.example.myapplication.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ProductActivity extends AppCompatActivity {

    //Firebase init
    RecyclerView recyclerView;
    Env_Certificate_FirebaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //firebase get certificates
        FirebaseRecyclerOptions<Env_Certificate> options =
                new FirebaseRecyclerOptions.Builder<Env_Certificate>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Certificates"), Env_Certificate.class)
                        .build();

        adapter=new Env_Certificate_FirebaseAdapter(options);
        recyclerView=findViewById(R.id.certificate__recycler_view_per_product);
        adapter.startListening();

        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

    }
}
package com.example.amazigh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class categoriesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    categoryAdapter adapter;
    DatabaseReference databaseReference;

    List<category> list;
    private static final String TAG = "categoriesActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        recyclerView = findViewById(R.id.recycler);


        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        list = new ArrayList<>();

        adapter = new categoryAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(adapter);

        /*
        FirebaseRecyclerOptions<category> options
            = new FirebaseRecyclerOptions.Builder<category>().setQuery(amazigh.child("0").child("info"), category.class).build();

         */

        getDataFirebase();
    }

    public void getDataFirebase(){
        Query query = databaseReference.child("Categorie");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d(TAG, "ERROR: " + dataSnapshot);

                if(dataSnapshot.hasChildren()){
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        category categorymodel = new category();

                        categorymodel.setNamecategory(snapshot.getKey());

                        list.add(categorymodel);
                    }

                    adapter = new categoryAdapter(getApplicationContext(), list);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Log.d(TAG, "onCancelled: " + error);
            }
        });
    }
}

package com.example.projectuas.watersource;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.projectuas.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class watersource extends AppCompatActivity {
    //widget
    RecyclerView recyclerView;
    // firebase:
    public DatabaseReference myRef;
    // Variable
    private ArrayList<messages> messageList;
    private RecyclerAdapter recyclerAdapter;
    private Context mContext;
    ImageView imageView;
     Context context;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        recyclerView =findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //Firebase
        myRef = FirebaseDatabase.getInstance().getReference();

        //Arraylist
        messageList=new ArrayList<>();

        //Clear ArrayList:
        ClearAll();

        //Get Data Method
        GetDataFromFirebase();

        imageView=findViewById(R.id.exitIcon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void GetDataFromFirebase() {

        Query query=myRef.child("message");

       query.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    messages messages=new messages();

                    if (snapshot.child("url").getValue() != null) {
                        messages.setImageUrl(snapshot.child("url").getValue().toString());
                    }
                    if (snapshot.child("nama").getValue() != null) {
                        messages.setName(snapshot.child("nama").getValue().toString());
                    }
                    if (snapshot.child("description").getValue() != null) {
                        messages.setDescription(snapshot.child("description").getValue().toString());
                    }

                    messageList.add(messages);
                }
                recyclerAdapter=new RecyclerAdapter(getApplicationContext(),messageList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("watersource", "Error fetching data from Firebase: " + error.getMessage());
            }
        });




    }
    private void ClearAll(){
        if(messageList !=null){
            messageList.clear();

            if(recyclerAdapter !=null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }
        messageList=new ArrayList<>();
    }
}
package com.example.myapplication.DBUtils;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDataBase;
    private DatabaseReference mReferenceParkingSpots;
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<ParkingSpot>parkingSpots,List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }
    public FirebaseDatabaseHelper() {
        mDataBase = FirebaseDatabase.getInstance();
        mReferenceParkingSpots = mDataBase.getReference("ParkingSpots");
    }

    public void readParkingSpots(final DataStatus dataStatus){
        mReferenceParkingSpots.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                parkingSpots.clear();
                List<String> keys= new ArrayList<>();
                for(DataSnapshot keyNode: snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    ParkingSpot parkingSpot = keyNode.getValue(ParkingSpot.class);
                    parkingSpots.add(parkingSpot);
                }
                dataStatus.DataIsLoaded(parkingSpots,keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

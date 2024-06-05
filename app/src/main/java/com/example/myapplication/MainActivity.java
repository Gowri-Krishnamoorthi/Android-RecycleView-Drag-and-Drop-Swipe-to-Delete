package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Integer> imageResources; // List of image resource IDs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        imageResources = new ArrayList<>();
        // Add your image resource IDs to the list
        imageResources.add(R.drawable.baseline_book_online_24);
        imageResources.add(R.drawable.baseline_calendar_today_24);
        imageResources.add(R.drawable.baseline_call_24);
        imageResources.add(R.drawable.baseline_call_end_24);
        imageResources.add(R.drawable.baseline_call_to_action_24);
        imageResources.add(R.drawable.baseline_book_online_24);
        imageResources.add(R.drawable.baseline_calendar_today_24);
        imageResources.add(R.drawable.baseline_call_24);
        imageResources.add(R.drawable.baseline_call_end_24);
        imageResources.add(R.drawable.baseline_call_to_action_24);

        // Add more images as needed

        adapter = new ItemAdapter(imageResources); // Pass the list of image resource IDs to the adapter
        recyclerView.setAdapter(adapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();
                adapter.moveItem(fromPosition, toPosition);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                adapter.removeItem(position);
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}

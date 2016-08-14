package io.github.sanjeet291196.express;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<DataItem> dataItems = new ArrayList<>();
        dataItems.add(new DataItem("English", "Hindi", "Local"));

        DataAdapter adapter = new DataAdapter(this, dataItems);
        ListView numberItemListView = (ListView) findViewById(R.id.NumberItemListView);
        numberItemListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}

package io.github.sanjeet291196.express;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<DataItem> dataItems = new ArrayList<>();
        dataItems.add(new DataItem(R.drawable.color_black, "Black", "Kaala(काला)", ""));
        dataItems.add(new DataItem(R.drawable.color_brown, "Brown", "Bhoora(भूरा)", ""));
        dataItems.add(new DataItem(R.drawable.color_dusty_yellow, "Dusty Yellow", "Gehra Peela(गहरा पीला)", ""));
        dataItems.add(new DataItem(R.drawable.color_gray, "Gray", "Bhoora(भूरा)", ""));
        dataItems.add(new DataItem(R.drawable.color_green, "Green", "Hara(हरा)", ""));
        dataItems.add(new DataItem(R.drawable.color_mustard_yellow, "Yellow", "Peela(पीला)", ""));
        dataItems.add(new DataItem(R.drawable.color_red, "Red", "Laal(लाल)", ""));
        dataItems.add(new DataItem(R.drawable.color_white, "White", "Saphed(सफेद)", ""));

        DataAdapter adapter = new DataAdapter(this, dataItems);
        ListView colorItemListView = (ListView) findViewById(R.id.color_item_listview);
        colorItemListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}

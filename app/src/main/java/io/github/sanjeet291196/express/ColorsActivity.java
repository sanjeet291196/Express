package io.github.sanjeet291196.express;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

/**
 * @author sanjit
 *         ColorsActivity to diplay colors in different language
 */
public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("B57E80B764791677F26544661D06015F")
                .build();
        adView.loadAd(adRequest);


        // array list to store data items
        ArrayList<DataItem> dataItems = new ArrayList<>();

        // add color data items to dataItems array list
        dataItems.add(new DataItem(R.drawable.color_black, "Black", "Kaala(काला)", ""));
        dataItems.add(new DataItem(R.drawable.color_brown, "Brown", "Bhoora(भूरा)", ""));
        dataItems.add(new DataItem(R.drawable.color_dusty_yellow, "Dusty Yellow", "Gehra Peela(गहरा पीला)", ""));
        dataItems.add(new DataItem(R.drawable.color_gray, "Gray", "Bhoora(भूरा)", ""));
        dataItems.add(new DataItem(R.drawable.color_green, "Green", "Hara(हरा)", ""));
        dataItems.add(new DataItem(R.drawable.color_mustard_yellow, "Yellow", "Peela(पीला)", ""));
        dataItems.add(new DataItem(R.drawable.color_red, "Red", "Laal(लाल)", ""));
        dataItems.add(new DataItem(R.drawable.color_white, "White", "Saphed(सफेद)", ""));

        // adapter for linking dataItems to colorItemListView
        DataAdapter adapter = new DataAdapter(this, dataItems);
        // colorItemListView to display colors in related list
        ListView colorItemListView = (ListView) findViewById(R.id.color_item_listview);
        // set the adapter for the colorItemListView
        colorItemListView.setAdapter(adapter);
        // notify the adapter to refresh the list
        adapter.notifyDataSetChanged();

    }
}

package io.github.sanjeet291196.express;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

/**
 * @author sanjit
 *         NumbersActivity to diplay number pronounciation in different languages
 */
public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("B57E80B764791677F26544661D06015F")
                .build();
        adView.loadAd(adRequest);


        // array list to store data items
        ArrayList<DataItem> dataItems = new ArrayList<>();
        // add number data items to dataItems array list
        dataItems.add(new DataItem(R.drawable.number_one, "One", "Ek(एक)", "Okati"));
        dataItems.add(new DataItem(R.drawable.number_two, "Two", "Do(दो)", "Reṇḍu"));
        dataItems.add(new DataItem(R.drawable.number_three, "Three", "Teen(तीन)", "Mūḍu"));
        dataItems.add(new DataItem(R.drawable.number_four, "Four", "Chaar(चार)", "Nālugu"));
        dataItems.add(new DataItem(R.drawable.number_five, "Five", "Paanch(पांच)", "Aidu"));
        dataItems.add(new DataItem(R.drawable.number_six, "Six", "Cheh(छह)", "Aru"));
        dataItems.add(new DataItem(R.drawable.number_seven, "Seven", "Saat(सात)", "Eḍu"));
        dataItems.add(new DataItem(R.drawable.number_eight, "Eight", "Aath(आठ)", "Enimidi"));
        dataItems.add(new DataItem(R.drawable.number_nine, "Nine", "Nau(नौ)", "Tom'midi"));
        dataItems.add(new DataItem(R.drawable.number_ten, "Ten", "Das(दस)", "Padi"));

        // add number greater than 10 data items to dataItems array list
        dataItems.add(new DataItem(R.drawable.number_one, "Eleven", "Gyaarah(ग्यारह)", "Padakoṇḍu", true));
        dataItems.add(new DataItem(R.drawable.number_two, "Twelve", "Baarah(बारह)", "Panneṇḍu", true));
        dataItems.add(new DataItem(R.drawable.number_three, "Thirteen", "Terah(तेरह)", "Padamūḍu", true));
        dataItems.add(new DataItem(R.drawable.number_four, "Fourteen", "Chaudah(चौदह)", "Padnālugu", true));
        dataItems.add(new DataItem(R.drawable.number_five, "Fifteen", "Pandrah(पंद्रह)", "Padihēnu", true));
        dataItems.add(new DataItem(R.drawable.number_six, "Sixteen", "Solah(सोलह)", "Padahāru", true));
        dataItems.add(new DataItem(R.drawable.number_seven, "Seventeen", "Satrah(सत्रह)", "Padihēḍu", true));
        dataItems.add(new DataItem(R.drawable.number_eight, "Eighteen", "Athaarah(अठारह)", "Paddenimidi", true));
        dataItems.add(new DataItem(R.drawable.number_nine, "Nineteen", "Unnees(उन्नीस)", "Nainṭīn", true));
        dataItems.add(new DataItem(R.drawable.number_ten, "Twenty", "Bees(बीस)", "Iravai", true));

        // adapter for linking dataItems to numberItemListView
        DataAdapter adapter = new DataAdapter(this, dataItems);
        // numberItemListView to display colors in related list
        ListView numberItemListView = (ListView) findViewById(R.id.number_item_listview);
        // set the adapter for the numberItemListView
        numberItemListView.setAdapter(adapter);
        // notify the adapter to refresh the list
        adapter.notifyDataSetChanged();
    }
}

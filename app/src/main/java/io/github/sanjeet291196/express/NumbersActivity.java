package io.github.sanjeet291196.express;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * @author sanjit
 *         NumbersActivity to diplay number pronounciation in different languages
 */
public class NumbersActivity extends AppCompatActivity {

    private final String REFERENCE_ID = "Numbers";
    DataAdapter adapter;


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
        final ArrayList<DataItem> dataItems = new ArrayList<>();
        // adapter for linking dataItems to numberItemListView
        adapter = new DataAdapter(this, dataItems);
        // numberItemListView to display colors in related list
        ListView numberItemListView = (ListView) findViewById(R.id.number_item_listview);
        // set the adapter for the numberItemListView
        numberItemListView.setAdapter(adapter);
        // notify the adapter to refresh the list
        adapter.notifyDataSetChanged();


        DatabaseReference reference = MainMenu.database.getReference(REFERENCE_ID);

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DataItem newDataItem = dataSnapshot.getValue(DataItem.class);

                if (newDataItem != null) {
                    dataItems.add(newDataItem);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

     /*   DataItem[] dataItem = new DataItem[]{
                new DataItem(R.drawable.number_one, "One", "Ek(एक)", "Okati"),
                new DataItem(R.drawable.number_two, "Two", "Do(दो)", "Reṇḍu"),
                new DataItem(R.drawable.number_three, "Three", "Teen(तीन)", "Mūḍu"),
                new DataItem(R.drawable.number_four, "Four", "Chaar(चार)", "Nālugu"),
                new DataItem(R.drawable.number_five, "Five", "Paanch(पांच)", "Aidu"),
                new DataItem(R.drawable.number_six, "Six", "Cheh(छह)", "Aru"),
                new DataItem(R.drawable.number_seven, "Seven", "Saat(सात)", "Eḍu"),
                new DataItem(R.drawable.number_eight, "Eight", "Aath(आठ)", "Enimidi"),
                new DataItem(R.drawable.number_nine, "Nine", "Nau(नौ)", "Tom'midi"),
                new DataItem(R.drawable.number_ten, "Ten", "Das(दस)", "Padi"),


                (new DataItem(R.drawable.number_one, "Eleven", "Gyaarah(ग्यारह)", "Padakoṇḍu", true)),
                (new DataItem(R.drawable.number_two, "Twelve", "Baarah(बारह)", "Panneṇḍu", true)),
                (new DataItem(R.drawable.number_three, "Thirteen", "Terah(तेरह)", "Padamūḍu", true)),
                (new DataItem(R.drawable.number_four, "Fourteen", "Chaudah(चौदह)", "Padnālugu", true)),
                (new DataItem(R.drawable.number_five, "Fifteen", "Pandrah(पंद्रह)", "Padihēnu", true)),
                (new DataItem(R.drawable.number_six, "Sixteen", "Solah(सोलह)", "Padahāru", true)),
                (new DataItem(R.drawable.number_seven, "Seventeen", "Satrah(सत्रह)", "Padihēḍu", true)),
                (new DataItem(R.drawable.number_eight, "Eighteen", "Athaarah(अठारह)", "Paddenimidi", true)),
                (new DataItem(R.drawable.number_nine, "Nineteen", "Unnees(उन्नीस)", "Nainṭīn", true)),
                (new DataItem(R.drawable.number_ten, "Twenty", "Bees(बीस)", "Iravai", true))
        };

        for (int d = 0; d < dataItem.length; d++) {
            reference.child(String.valueOf(d + 1)).setValue(dataItem[d]);
        }
    */
    }

    @Override
    protected void onDestroy() {
        adapter.shutdownt();
        super.onDestroy();
    }
}

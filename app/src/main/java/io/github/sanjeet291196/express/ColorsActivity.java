package io.github.sanjeet291196.express;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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
 *         ColorsActivity to diplay colors in different language
 */
public class ColorsActivity extends AppCompatActivity {

    private static final String REFERENCE_ID = "Colors";
    DataAdapter adapter;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("B57E80B764791677F26544661D06015F")
                .build();
        adView.loadAd(adRequest);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // array list to store data items
        final ArrayList<DataItem> dataItems = new ArrayList<>();

        // adapter for linking dataItems to colorItemListView
        adapter = new DataAdapter(this, dataItems);
        // colorItemListView to display colors in related list
        ListView colorItemListView = (ListView) findViewById(R.id.color_item_listview);
        // set the adapter for the colorItemListView
        colorItemListView.setAdapter(adapter);
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

    /*    DataItem[] dataItem = new DataItem[]{
                (new DataItem(R.drawable.color_black, "Black", "Kaala(काला)", "")),
                (new DataItem(R.drawable.color_brown, "Brown", "Bhoora(भूरा)", "")),
                (new DataItem(R.drawable.color_dusty_yellow, "Dusty Yellow", "Gehra Peela(गहरा पीला)", "")),
                (new DataItem(R.drawable.color_gray, "Gray", "Bhoora(भूरा)", "")),
                (new DataItem(R.drawable.color_green, "Green", "Hara(हरा)", "")),
                (new DataItem(R.drawable.color_mustard_yellow, "Yellow", "Peela(पीला)", "")),
                (new DataItem(R.drawable.color_red, "Red", "Laal(लाल)", "")),
                (new DataItem(R.drawable.color_white, "White", "Saphed(सफेद),", ""))
        };

        for (DataItem d : dataItem) {
            reference.child(d.getEnglishTranslation()).setValue(d);
        }
*/
    }

    @Override
    protected void onDestroy() {
        adapter.shutdownt();
        super.onDestroy();
    }
}

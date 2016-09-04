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
 *         FamilyMemberActivity to display names of family members in different languages
 */
public class FamilyMemberActivity extends AppCompatActivity {

    private static final String REFERENCE_ID = "Family Members";
    DataAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_member);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("B57E80B764791677F26544661D06015F")
                .build();
        adView.loadAd(adRequest);

        // array list to store data items
        final ArrayList<DataItem> dataItems = new ArrayList<>();

        // adapter for linking dataItems to familyItemListView
        adapter = new DataAdapter(this, dataItems);
        // familyItemListView to display colors in related list
        ListView familyItemListView = (ListView) findViewById(R.id.family_item_listview);
        // set the adapter for the familyItemListView
        familyItemListView.setAdapter(adapter);
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

   /*     DataItem[] dataItem = new DataItem[]{
                (new DataItem(R.drawable.family_grandfather, "Grand Father", "Daada(दादा)", "Tāta")),
                (new DataItem(R.drawable.family_grandmother, "Grand Mother", "Daadee ma(दादी मा)", "Am'mam'ma")),
                (new DataItem(R.drawable.family_father, "Father", "Pita(पिता)", "Taṇḍri")),
                (new DataItem(R.drawable.family_mother, "Mother", "Maan(मां)", "Talli")),
                (new DataItem(R.drawable.family_son, "Son", "Beta(बेटा)", "Kumāruḍu")),
                (new DataItem(R.drawable.family_daughter, "Daughter", "Betee(बेटी)", "kumārte")),
                (new DataItem(R.drawable.family_older_brother, "Elder Brother", "Bhaiyya(भैया)", "Annayya")),
                (new DataItem(R.drawable.family_older_sister, "Elder Sister", "Deedee(दीदी)", "Akka")),
                (new DataItem(R.drawable.family_younger_brother, "Younger Brother", "Bhaee(भाई)", "Tam'muḍu")),
                (new DataItem(R.drawable.family_younger_sister, "Younger Sister", "Bahan(बहन)", "Chinna Celli"))
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

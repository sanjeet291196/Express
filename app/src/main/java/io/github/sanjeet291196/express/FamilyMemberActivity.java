package io.github.sanjeet291196.express;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

/**
 * @author sanjit
 *         FamilyMemberActivity to display names of family members in different languages
 */
public class FamilyMemberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_member);

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("B57E80B764791677F26544661D06015F")
                .build();
        adView.loadAd(adRequest);

        // array list to store data items
        ArrayList<DataItem> dataItems = new ArrayList<>();
        // add family member data items to dataItems array list
        dataItems.add(new DataItem(R.drawable.family_grandfather, "Grand Father", "Daada(दादा)", "Tāta"));
        dataItems.add(new DataItem(R.drawable.family_grandmother, "Grand Mother", "Daadee ma(दादी मा)", "Am'mam'ma"));
        dataItems.add(new DataItem(R.drawable.family_father, "Father", "Pita(पिता)", "Taṇḍri"));
        dataItems.add(new DataItem(R.drawable.family_mother, "Mother", "Maan(मां)", "Talli"));
        dataItems.add(new DataItem(R.drawable.family_son, "Son", "Beta(बेटा)", "Kumāruḍu"));
        dataItems.add(new DataItem(R.drawable.family_daughter, "Daughter", "Betee(बेटी)", "kumārte"));
        dataItems.add(new DataItem(R.drawable.family_older_brother, "Elder Brother", "Bhaiyya(भैया)", "Annayya"));
        dataItems.add(new DataItem(R.drawable.family_older_sister, "Elder Sister", "Deedee(दीदी)", "Akka"));
        dataItems.add(new DataItem(R.drawable.family_younger_brother, "Younger Brother", "Bhaee(भाई)", "Tam'muḍu"));
        dataItems.add(new DataItem(R.drawable.family_younger_sister, "Younger Sister", "Bahan(बहन)", "Chinna Celli"));

        // adapter for linking dataItems to familyItemListView
        DataAdapter adapter = new DataAdapter(this, dataItems);
        // familyItemListView to display colors in related list
        ListView familyItemListView = (ListView) findViewById(R.id.family_item_listview);
        // set the adapter for the familyItemListView
        familyItemListView.setAdapter(adapter);
        // notify the adapter to refresh the list
        adapter.notifyDataSetChanged();

    }
}

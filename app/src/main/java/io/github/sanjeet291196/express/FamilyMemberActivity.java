package io.github.sanjeet291196.express;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMemberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_member);

        ArrayList<DataItem> dataItems = new ArrayList<>();
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

        DataAdapter adapter = new DataAdapter(this, dataItems);
        ListView familyItemListView = (ListView) findViewById(R.id.family_item_listview);
        familyItemListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}

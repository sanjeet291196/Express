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

        DataAdapter adapter = new DataAdapter(this, dataItems);
        ListView numberItemListView = (ListView) findViewById(R.id.number_item_listview);
        numberItemListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}

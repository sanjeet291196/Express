package io.github.sanjeet291196.express;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumberFragment extends Fragment {

    private final String REFERENCE_ID = "Numbers";
    private DataAdapter adapter;

    public NumberFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // array list to store data items
        final ArrayList<DataItem> dataItems = new ArrayList<>();

        DataItem[] dataItem = new DataItem[]{
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

        Collections.addAll(dataItems, dataItem);

        // adapter for linking dataItems to numberItemListView
        adapter = new DataAdapter(getActivity(), dataItems);
        // numberItemListView to display colors in related list
        ListView numberItemListView = (ListView) rootView.findViewById(R.id.item_listview);
        numberItemListView.setBackgroundColor(getResources().getColor(R.color.colorNumbers));
        // set the adapter for the numberItemListView
        numberItemListView.setAdapter(adapter);
        // notify the adapter to refresh the list
        adapter.notifyDataSetChanged();

/*
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
        });*/

     /*

        for (int d = 0; d < dataItem.length; d++) {
            reference.child(String.valueOf(d + 1)).setValue(dataItem[d]);
        }
    */

        return rootView;

    }

    @Override
    public void onDestroyView() {
        adapter.shutdownt();
        super.onDestroyView();
    }

}

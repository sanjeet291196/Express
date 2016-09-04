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
public class ColorsFragment extends Fragment {

    private static final String REFERENCE_ID = "Colors";
    private DataAdapter adapter;

    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // array list to store data items
        final ArrayList<DataItem> dataItems = new ArrayList<>();

        DataItem[] dataItem = new DataItem[]{
                (new DataItem(R.drawable.color_black, "Black", "Kaala(काला)", "")),
                (new DataItem(R.drawable.color_brown, "Brown", "Bhoora(भूरा)", "")),
                (new DataItem(R.drawable.color_dusty_yellow, "Dusty Yellow", "Gehra Peela(गहरा पीला)", "")),
                (new DataItem(R.drawable.color_gray, "Gray", "Bhoora(भूरा)", "")),
                (new DataItem(R.drawable.color_green, "Green", "Hara(हरा)", "")),
                (new DataItem(R.drawable.color_mustard_yellow, "Yellow", "Peela(पीला)", "")),
                (new DataItem(R.drawable.color_red, "Red", "Laal(लाल)", "")),
                (new DataItem(R.drawable.color_white, "White", "Saphed(सफेद),", ""))
        };

        Collections.addAll(dataItems, dataItem);

        // adapter for linking dataItems to colorItemListView
        adapter = new DataAdapter(getActivity(), dataItems);
        // colorItemListView to display colors in related list
        ListView colorItemListView = (ListView) rootView.findViewById(R.id.item_listview);
        colorItemListView.setBackgroundColor(getResources().getColor(R.color.colorColors));
        // set the adapter for the colorItemListView
        colorItemListView.setAdapter(adapter);
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
        });
*/

    /*

        for (DataItem d : dataItem) {
            reference.child(d.getEnglishTranslation()).setValue(d);
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

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
public class FamilyMembersFragment extends Fragment {


    private static final String REFERENCE_ID = "Family Members";
    private DataAdapter adapter;

    public FamilyMembersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // array list to store data items
        final ArrayList<DataItem> dataItems = new ArrayList<>();

        DataItem[] dataItem = new DataItem[]{
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

        Collections.addAll(dataItems, dataItem);

        // adapter for linking dataItems to familyItemListView
        adapter = new DataAdapter(getActivity(), dataItems);
        // familyItemListView to display colors in related list
        ListView familyItemListView = (ListView) rootView.findViewById(R.id.item_listview);
        familyItemListView.setBackgroundColor(getResources().getColor(R.color.colorFamily));
        // set the adapter for the familyItemListView
        familyItemListView.setAdapter(adapter);
        // notify the adapter to refresh the list
        adapter.notifyDataSetChanged();

        /*DatabaseReference reference = MainMenu.database.getReference(REFERENCE_ID);

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

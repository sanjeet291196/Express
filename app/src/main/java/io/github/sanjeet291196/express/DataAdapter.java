package io.github.sanjeet291196.express;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sanjit on 14/8/16.
 * Project: Express
 */
public class DataAdapter extends ArrayAdapter<DataItem> {
    public DataAdapter(Context context, List<DataItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View dataView = convertView;
        if (dataView == null) {
            dataView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }

        DataItem currentDataItem = getItem(position);

        ImageView icon = (ImageView) dataView.findViewById(R.id.ItemIcon);
        ImageView icon2 = (ImageView) dataView.findViewById(R.id.ItemIcon2);

        if (currentDataItem.isPhrase()) {
            icon.setVisibility(View.GONE);
            icon2.setVisibility(View.GONE);
        } else {
            if (currentDataItem.isPlus10()) {
                icon.setImageResource(R.drawable.number_ten);
                icon2.setImageResource(currentDataItem.getImageResourceId());
                icon2.setVisibility(View.VISIBLE);
            } else {
                icon.setImageResource(currentDataItem.getImageResourceId());
                icon2.setVisibility(View.GONE);
            }
        }

        TextView englishTranslation = (TextView) dataView.findViewById(R.id.ItemEnglishTranslation);
        englishTranslation.setText(currentDataItem.getEnglishTranslation());

        TextView hindiTranslation = (TextView) dataView.findViewById(R.id.ItemHindiTranslation);
        hindiTranslation.setText(currentDataItem.getHindiTranslation());

        TextView localTranslation = (TextView) dataView.findViewById(R.id.ItemLocalTranslation);
        localTranslation.setText(currentDataItem.getLocalTranslation());

        return dataView;
    }
}

package own.code.newsfetcher;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created in NewsFetcher on 2/22/2017.
 */

public class NewsAdapter extends ArrayAdapter<NewsFeed> {

    private TextView tvArticleName;

    public NewsAdapter(Context context, int resource, ArrayList<NewsFeed> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.news_feed, null);
        }
        NewsFeed temp = getItem(position);
        tvArticleName = (TextView) v.findViewById(R.id.tvArticleTopic);
        tvArticleName.setText(temp.getTitle());
        return v;
    }

}

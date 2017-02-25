package own.code.newsfetcher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<NewsFeed>> {

    private String LOG_TAG = getClass().getSimpleName();

    private NewsAdapter newsAdapter;
    private ListView listView;
    private String newsArticleUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listArticle);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsFeed temp = (NewsFeed) parent.getItemAtPosition(position);
                Log.d(LOG_TAG, temp.getNews_url());
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(temp.getNews_url()));
                startActivity(i);
            }
        });
        newsArticleUrl = urlManager.getArticle_the_hindu_url();
        getSupportLoaderManager().initLoader(0, null, this).forceLoad();
    }

    @Override
    public Loader<ArrayList<NewsFeed>> onCreateLoader(int id, Bundle args) {
        return new NewsArticleLoader(MainActivity.this, newsArticleUrl);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<NewsFeed>> loader, ArrayList<NewsFeed> data) {
        newsAdapter = new NewsAdapter(this, 0, data);
        updateUI(newsAdapter);
    }

    private void updateUI(NewsAdapter adapter) {
        listView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<NewsFeed>> loader) {
        newsAdapter = new NewsAdapter(this, 0, new ArrayList<NewsFeed>());
    }
}

package own.code.newsfetcher;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<NewsFeed>> {

    private NewsAdapter newsAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listArticle);
        getSupportLoaderManager().initLoader(0, null, this).forceLoad();
    }

    @Override
    public Loader<ArrayList<NewsFeed>> onCreateLoader(int id, Bundle args) {
        return new NewsArticleLoader(MainActivity.this, urlManager.getArticle_url());
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

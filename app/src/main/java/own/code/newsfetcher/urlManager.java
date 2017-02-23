package own.code.newsfetcher;

/**
 * Created in NewsFetcher on 2/22/2017.
 */

public final class urlManager {
    private static String Article_url = "https://newsapi.org/v1/articles?source=" + "the-hindu" + "&sortBy=latest&apiKey=" + "e1e2e737471c49a4b1e981f086f30c4c";

    public urlManager() {
        Article_url = "";
    }

    public static String getArticle_url() {
        return Article_url;
    }
}

package espproject;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import java.io.*;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

public class callTwitterApi {
	
	//private static final String TWITTER_CONSUMER_KEY = "iAhG5x0Vhxx1tbdexON6BZgQJ";
	//private static final String TWITTER_SECRET_KEY = "BqS2FkL642cWyWQDiYnHcHh7gQe4giEwyUWaojE4QngGYbyhAC";
	//private static final String TWITTER_ACCESS_TOKEN = "uaT8GcRwynHKRg4wzUZ5ExO6XIdJ7BePLlcQ1T3pN";
	//private static final String TWITTER_ACCESS_TOKEN_SECRET = "nPiNVOuemZdCBF6FDhaZ7SXejXApSV1163YzuExncNtNy";
	
	private static final String TWITTER_CONSUMER_KEY = "iAhG5x0Vhxx1tbdexON6BZgQJ";
	private static final String TWITTER_SECRET_KEY = "BqS2FkL642cWyWQDiYnHcHh7gQe4giEwyUWaojE4QngGYbyhAC";
	private static final String TWITTER_ACCESS_TOKEN = "22905637-uaT8GcRwynHKRg4wzUZ5ExO6XIdJ7BePLlcQ1T3pN";
	private static final String TWITTER_ACCESS_TOKEN_SECRET = "nPiNVOuemZdCBF6FDhaZ7SXejXApSV1163YzuExncNtNy";
	
	public static SearchTweets getTweetsUsingSearch(String searchPar, ServletContext context) {

		
		
		try {
			OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(TWITTER_CONSUMER_KEY, TWITTER_SECRET_KEY);
			oAuthConsumer.setTokenWithSecret(TWITTER_ACCESS_TOKEN, TWITTER_ACCESS_TOKEN_SECRET);

			URIBuilder builder = new URIBuilder();
			builder.setScheme("https").setHost("api.twitter.com").setPath("/1.1/search/tweets.json")
					.setParameter("q", searchPar).setParameter("count", "100").setParameter("lang","en");
			URI uri = builder.build();
			HttpGet get = new HttpGet(uri);
			oAuthConsumer.sign(get);

			HttpClient httpClient = HttpClientBuilder.create().build();
			String data = "";
			HttpResponse httpResponse = httpClient.execute(get);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				System.out.println("Computed URI: " + uri.toString());
				data = IOUtils.toString(httpResponse.getEntity().getContent());
				SearchTweets searchTweets = TwitterAPIHelper.getTweetsBySearching(data, searchPar, context);
				// Twitter returned tweets matching the search term.
				return searchTweets;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

package espproject;

import java.io.IOException;

import javax.servlet.ServletContext;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TwitterAPIHelper {

	public static SearchTweets getTweetsBySearching(String data, String product, ServletContext context) {
		SearchTweets searchTweets = null;
		mongoConnect insTweet=new mongoConnect();
		sentimentAnalysis calScore=new sentimentAnalysis();
		double score;
		ObjectMapper mapper = new ObjectMapper();
		int h;
		 int countI =0;
		try {
			searchTweets = mapper.readValue(data, SearchTweets.class);
			
				//String tweetsStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(searchTweets);
			//	System.out.println(tweetsStr);
				for(h=0;h<searchTweets.getStatuses().size();h++)
				{
					//System.out.println(searchTweets.getStatuses().get(h).getText());
					//System.out.println("*********");
					score=calScore.calSentimentScore(searchTweets.getStatuses().get(h).getText(),searchTweets.getStatuses().get(h).getRetweetCount().intValue() , searchTweets.getStatuses().get(h).getFavoriteCount().intValue(),  context);
				//	insTweet.insertMongoData(searchTweets.getStatuses().get(h).getId().toString(), searchTweets.getStatuses().get(h).getUser().getTimeZone(),searchTweets.getStatuses().get(h).getCreatedAt() , searchTweets.getStatuses().get(h).getRetweetCount().intValue(), searchTweets.getStatuses().get(h).getFavoriteCount().intValue(), score, searchTweets.getStatuses().get(h).getText(), product);
					
				}
				//insTweet.insertMongoData1(product,"no review", "no review", "no review", "no review");
				System.out.println(h);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return searchTweets;
	}
}

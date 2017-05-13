package espproject;
/*import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import com.mongodb.ServerAddress;*/
import connectivity.DatabaseConnectivity;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class mongoConnect {
	
	public  static DatabaseConnectivity myClass;
	
	// TODO Auto-generated method stub
	
	public static void insertMongoData(String tweetid,String timezone,String timestamp,int retweetcount, int favorited,double sentimentscore,String tweettext,String productname)
	{
				myClass=new DatabaseConnectivity();
				String query;
				query="insert into `cloudtrade1`.`tweetstable` (`tweetid`, `timezone`, `timestamp`,`retweetcount`,`favorited`, `sentimentscore`, `tweettext`, `tweetproductname`) values ('" + tweetid + "','" + timezone + "','" ;
				query=query + timestamp + "'," + retweetcount + "," + favorited + "," + sentimentscore + ",'" + tweettext + "','" + productname + "')";
				try {
					if(myClass.crud(query)>0)
					{
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				       
				        //System.out.println("Inserted successfully");
	}
	public static void insertMongoData1(String productName,String rEview1,String rEview2,String rEview3,String rEview4)
	{
		myClass=new DatabaseConnectivity();
		String query;
		query="insert into `cloudtrade1`.`tweetproducts` (`tproductname`, `present`, `review1`,`review2`,`review3`, `review4`) values ('" + productName + "'," + 0 + ",'" ;
		query=query + rEview1 + "','" + rEview2 + "','" + rEview3 + "','" + rEview4 + "')";
		try {
			if(myClass.crud(query)>0)
			{
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	
//	public static String returnMongoData()
//	{
//		String retTweet="Hello";
//		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//		DB db = mongoClient.getDB("espdb");
//		DBCollection coll1 = db.getCollection("tweetstable");
//		DBCursor cursor = coll1.find();
//		DBObject tempobj;
//		double realScore=0;
//		sentimentAnalysis s=new sentimentAnalysis();
//		while(cursor.hasNext()) {
//			tempobj=cursor.next();
//			realScore=s.calSentimentScore(tempobj.get("tweettext").toString(),Integer.valueOf(tempobj.get("retweetcount").toString()),Integer.valueOf(tempobj.get("favorited").toString()));
//		   // System.out.println(cursor.next());
//		}
//		
//		mongoClient.close();
//		return retTweet;
//	}
	
	

}

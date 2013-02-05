package by.giava.shoppingadvice.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.mongodb.util.JSON;

public class MongoDbTest
{
   public static void main(String[] args) throws IOException
   {
      MongoClient client = new MongoClient("localhost", 27017);
      DB db = client.getDB("TestDB");

      String newFileName = "mkyong-java-image";
      File imageFile = new File("img/fungo_cardoncello_001.jpg");
      GridFS gfsPhoto = new GridFS(db, "photo");
      GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);
      gfsFile.setFilename(newFileName);
      gfsFile.save();
      System.out.println(gfsFile.getId());
      BasicDBObject document1 = new BasicDBObject();
      document1.put("name", "mongo-doc");
      BasicDBObject document2 = new BasicDBObject();
      document2.put("name", "ciao");
      document2.put("image", gfsFile);
      db.getCollection("docs").insert(document2);
      DBCursor cursor = db.getCollection("docs").find();
      while (cursor.hasNext())
      {
         DBObject dbObj = cursor.next();
         System.out.println("id GLOBAL: " + dbObj.get("_id"));
         System.out.println("name: " + dbObj.get("name"));
         // System.out.println(dbObj);
         DBObject img = (DBObject) dbObj.get("image");
         System.out.println("id image: " + img.get("_id"));
         System.out.println("chunkSize image: " + img.get("chunkSize"));
         System.out.println("length image: " + img.get("length"));
         System.out.println("md5 image: " + img.get("md5"));
         System.out.println("filename image: " + img.get("filename"));
         System.out.println("contentType image: " + img.get("contentType"));
         System.out.println("uploadDate image: " + img.get("uploadDate"));
         System.out.println("**********************************************");
         // "chunkSize" : 262144 , "length" : 4614 , "md5" :
         // "b437aa2eb65a84de776e25a17f6237de" , "filename" : "mkyong-java-image" , "contentType" : null , "uploadDate"
         // : { "$date" : "2013-01-23T00:53:36.608Z"} , "aliases"
      }

      // gfsPhoto = new GridFS(db, "photo");
      // GridFSDBFile imageForOutput = gfsPhoto.findOne(newFileName);
      // System.out.println(imageForOutput);
   }
}

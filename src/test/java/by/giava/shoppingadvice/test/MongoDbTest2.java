package by.giava.shoppingadvice.test;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class MongoDbTest2
{
   public static void main(String[] args) throws UnknownHostException
   {

      BasicDBObject document1 = new BasicDBObject();
      document1.put("name", "mongo-doc");
      BasicDBObject document2 = new BasicDBObject();
      document2.put("name", "ciao");
      document2.put("doc", document1);
      ArrayList<DBObject> index = new ArrayList<DBObject>();
      index.add(BasicDBObjectBuilder.start()
               .add("name", "mw").add("value", 42.0922).get());
      index.add(BasicDBObjectBuilder.start()
               .add("name", "ΔfH°gas").add("value", 372.38).get());
      index.add(BasicDBObjectBuilder.start()
               .add("name", "S°gas").add("value", 216.81).get());
      document2.put("index", index);

      String obj = JSON.serialize(document2);
      System.out.println(obj);
   }

   public static void insert() throws UnknownHostException
   {
      DB db = getDb("localhost", 27017, "TestDB");
      // inserimento del primo documento
      DBObject jsonDocument = (DBObject) JSON.parse("{ name : 'mongo-doc' }");
      db.getCollection("things").insert(jsonDocument);

      // inserimento del primo documento
      BasicDBObject document = new BasicDBObject();
      document.put("name", "mongo-doc");
      db.getCollection("things").insert(document);

      DBCursor cursor = db.getCollection("things").find((BasicDBObject) JSON.parse("{name: 'mongo-doc'}"));
      while (cursor.hasNext())
      {
         System.out.println(cursor.next());
      }
   }

   private static MongoClient connect(String host, int port) throws UnknownHostException
   {
      MongoClient client = new MongoClient(host, port);
      return client;
   }

   private static DB getDb(MongoClient client, String dbName)
   {
      DB db = client.getDB("TestDB");
      return db;
   }

   private static DB getDb(String host, int port, String dbName) throws UnknownHostException
   {
      return getDb(connect(host, port), dbName);
   }
}

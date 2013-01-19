package by.giava.shoppingadvice.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SpesaInUtils
{

   public static String createQuery(int id)
   {
      try
      {
         // if you need to encode some text as parameter
         // + URLEncoder.encode(mode, "UTF-8")
         String query = "http://www.spesain.it/scheda.php?valore="
                  + id;
         return query;
      }
      catch (Exception ioe)
      {
         ioe.printStackTrace();
      }
      return null;
   }

   public static String getProduct(String query)
   {
      StringBuffer buffer = new StringBuffer();
      try
      {
         URL url = new URL(query);
         HttpURLConnection connection = (HttpURLConnection) url.openConnection();

         BufferedReader in = new BufferedReader(new InputStreamReader(
                  connection.getInputStream()));
         String inputLine;

         while ((inputLine = in.readLine()) != null)
            buffer.append(inputLine + "\n");
         in.close();
      }
      catch (Exception ioe)
      {
         ioe.printStackTrace();
      }

      return buffer.toString();
   }
}

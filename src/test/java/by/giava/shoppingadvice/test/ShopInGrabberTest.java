package by.giava.shoppingadvice.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import by.giava.shoppingadvice.model.Product;
import by.giava.shoppingadvice.util.FileUtils;
import by.giava.shoppingadvice.util.RegexUtils;
import by.giava.shoppingadvice.util.SpesaInUtils;

public class ShopInGrabberTest
{
   public static void main(String[] args)
   {
      List<Product> products = new ArrayList<Product>();
      List<Integer> notExistList = new ArrayList<Integer>();
      for (int i = 1; i <= 4610; i++)
      {
         Product product = shopImport(i, new File("log/single/" + i + ".txt"));
         if (product == null)
            notExistList.add(i);
         else
            products.add(product);

      }
   }

   private static Product shopImport(int i, File logFile)
   {
      String query = SpesaInUtils.createQuery(i);
      String html = SpesaInUtils.getProduct(query);
      Product product = RegexUtils.getProductFromHtml(html);
      if (logFile != null)
      {
         html = "query : \"" + query + "\"\n" + html;
         FileUtils.writeBytes(html.getBytes(), logFile);
      }
      return product;
   }
}

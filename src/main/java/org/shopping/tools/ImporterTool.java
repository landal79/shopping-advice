package org.shopping.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

public class ImporterTool
{

   private static final String UTF8 = "utf8";

   private static final String IMPORTING_D_S = "importing (%d) ... %s ";

   private static final String FILE_NAME = "imported.csv";

   private static final String PAGE_URL = "http://www.spesain.it/scheda.php?valore=%d";
   private static final String image_regex = "<div id\\=['\"]spesa_product['\"].*?><img src=['\"]foto/(.*?)['\"] class='img_pd'/>";
   private static final String product_regex = "<div id\\=['\"]scheda['\"].*?><h1.*?>(.*?)</h1>.*?</div>";
   private static final String brand_regex = "<td class=['\"]titolo['\"]>.*?Marca:.*?</td><td>(.*?)</td>";
   private static final String description_regex = "<td class=['\"]titolo['\"]>.*?Descrizione:.*?</td><td>(.*?)</td>";
   private static final String weight_regex = "<td class=['\"]titolo['\"]>.*?Confezione:.*?</td><td>(.*?)</td>";
   private static final String unityPrice_regex = "<td class=['\"]titolo['\"]>.*?Euro:.*?</td><td>(.*?)</td>";
   private static final String price_regex = "<td class=['\"]titolo['\"]><strong>Prezzo:</strong></td><td>(\\d+\\.?\\d*).*?</td>";

   private static final String ROW_PATTERN = "%s,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"\n";

   private static final long SLEEP_INTERVAL = 1000;

   /**
    * @param args
    */
   public static void main(String[] args)
   {

      try
      {
         // File file = new File(FILE_NAME);
         OutputStream os = new FileOutputStream(FILE_NAME);

         DataImporter importer = null;

         IOUtils.write(String.format(ROW_PATTERN, "ID", "PRODUCT", "BRAND", "DESCRIPTION", "WEIGHT", "UNITY_PRICE",
                  "PRICE", "IMG"), os);

         for (int i = 1; i <= 2; i++)
         {
            importer = new BaseDataImporter(image_regex, product_regex, brand_regex, description_regex, weight_regex,
                     unityPrice_regex, price_regex,
                     String.format(PAGE_URL, i));
            String importing = String.format(ROW_PATTERN, i, importer.getProductName(), importer.getProductBrand(),
                     importer.getDescription(), importer.getWeigth(), importer.getUnityPrice(), importer.getPrice(),
                     importer.getImageName());
            System.out.println(String.format(IMPORTING_D_S, i, importing));
            IOUtils.write(importing, os, UTF8);
            // Thread.currentThread().sleep(SLEEP_INTERVAL);
         }

         os.close();

      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

   }
}

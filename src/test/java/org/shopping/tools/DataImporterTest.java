package org.shopping.tools;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataImporterTest
{

   private static final String PAGE_URL = "http://www.spesain.it/scheda.php?valore=657";
   private static final String image_regex = "<div id\\=['\"]spesa_product['\"].*?><img src=['\"]foto/(.*?)['\"] class='img_pd'/>";
   private static final String product_regex = "<div id\\=['\"]scheda['\"].*?><h1.*?>(.*?)</h1>.*?</div>";
   private static final String brand_regex = "<td class=['\"]titolo['\"]>.*?Marca:.*?</td><td>(.*?)</td>";
   private static final String description_regex = "<td class=['\"]titolo['\"]>.*?Descrizione:.*?</td><td>(.*?)</td>";
   private static final String weight_regex = "<td class=['\"]titolo['\"]>.*?Confezione:.*?</td><td>(.*?)</td>";
   private static final String unityPrice_regex = "<td class=['\"]titolo['\"]>.*?Euro:.*?</td><td>(.*?)</td>";
   private static final String price_regex = "<td class=['\"]titolo['\"]><strong>Prezzo:</strong></td><td>(\\d+\\.?\\d*).*?</td>";

   private DataImporter importer;

   @Before
   public void initialize() throws Exception
   {
      importer = new BaseDataImporter(image_regex, product_regex, brand_regex, description_regex, weight_regex,
               unityPrice_regex,
               price_regex,
               PAGE_URL);
   }

   @Test
   public void test_getImageName()
   {
      String data = importer.getImageName();
      assertNotNull(data);
      assertEquals("S5000392.JPG", data);
   }

   @Test
   public void test_getProductName()
   {
      String data = importer.getProductName();
      assertNotNull(data);
      assertEquals("Mulino Bianco Grancereale", data);
   }

   @Test
   public void test_getProductBrand()
   {
      String data = importer.getProductBrand();
      assertNotNull(data);
      assertEquals("Barilla", data);
   }

   @Test
   public void test_getDescription()
   {
      String data = importer.getDescription();
      assertNotNull(data);
      assertEquals("Mix di cereali da colazione alla frutta", data);
   }

   @Test
   public void test_getWeigth()
   {
      String data = importer.getWeigth();
      assertNotNull(data);
      assertEquals("270gr", data);
   }

   @Test
   public void test_getPrice()
   {
      String data = importer.getPrice();
      assertNotNull(data);
      assertEquals("3.20", data);
   }

   public void test_write()
   {

   }

}

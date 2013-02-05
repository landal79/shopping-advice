package org.shopping.tools;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Preconditions;

public class BaseDataImporter implements DataImporter
{

   private String image_regex;
   private String product_regex;
   private String brand_regex;
   private String description_regex;
   private String weight_regex;
   private String unityPrice_regex;
   private String price_regex;

   private String pageContent;

   public BaseDataImporter(String image_regex, String product_regex, String brand_regex,
            String description_regex, String weight_regex, String unityPrice_regex, String price_regex,
            String pageUrl) throws MalformedURLException, IOException
   {
      super();
      Preconditions.checkArgument(StringUtils.isNotBlank(image_regex), "img regex must be not empty!");
      Preconditions.checkArgument(StringUtils.isNotBlank(product_regex), "product regex must be not empty!");
      Preconditions.checkArgument(StringUtils.isNotBlank(brand_regex), "brand regex must be not empty!");
      Preconditions.checkArgument(StringUtils.isNotBlank(description_regex), "description regex must be not empty!");
      Preconditions.checkArgument(StringUtils.isNotBlank(weight_regex), "weight regex must be not empty!");
      Preconditions.checkArgument(StringUtils.isNotBlank(unityPrice_regex),
               "unity price regex regex must be not empty!");
      Preconditions.checkArgument(StringUtils.isNotBlank(price_regex), "price regex must be not empty!");
      Preconditions.checkArgument(StringUtils.isNotBlank(pageUrl), "page url must be not empty!");

      this.image_regex = image_regex;
      this.product_regex = product_regex;
      this.brand_regex = brand_regex;
      this.description_regex = description_regex;
      this.weight_regex = weight_regex;
      this.unityPrice_regex = unityPrice_regex;
      this.price_regex = price_regex;
      this.pageContent = PageGetter.getWebPage(pageUrl);
   }

   public String getProductName()
   {
      return RegexMatcher.match(product_regex, pageContent);
   }

   @Override
   public String getProductBrand()
   {
      return RegexMatcher.match(brand_regex, pageContent);
   }

   @Override
   public String getDescription()
   {
      return RegexMatcher.match(description_regex, pageContent);
   }

   @Override
   public String getWeigth()
   {
      return RegexMatcher.match(weight_regex, pageContent);
   }

   @Override
   public String getUnityPrice()
   {
      return RegexMatcher.match(unityPrice_regex, pageContent);
   }

   @Override
   public String getPrice()
   {
      return RegexMatcher.match(price_regex, pageContent);
   }

   @Override
   public String getRawContent()
   {
      return pageContent;
   }

   @Override
   public String getImageName()
   {
      return RegexMatcher.match(image_regex, pageContent);
   }
}

package by.giava.shoppingadvice.model;

import java.io.Serializable;

public class Product implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private String id;
   private String product;
   private String brand;
   private String description;
   private String weight;
   private String unityPrice;
   private String price;
   private String image;
   private String webSite;

   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }

   public String getProduct()
   {
      return product;
   }

   public void setProduct(String product)
   {
      this.product = product;
   }

   public String getBrand()
   {
      return brand;
   }

   public void setBrand(String brand)
   {
      this.brand = brand;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public String getWeight()
   {
      return weight;
   }

   public void setWeight(String weight)
   {
      this.weight = weight;
   }

   public String getUnityPrice()
   {
      return unityPrice;
   }

   public void setUnityPrice(String unityPrice)
   {
      this.unityPrice = unityPrice;
   }

   public String getPrice()
   {
      return price;
   }

   public void setPrice(String price)
   {
      this.price = price;
   }

   public String getImage()
   {
      return image;
   }

   public void setImage(String image)
   {
      this.image = image;
   }

   public String getWebSite()
   {
      return webSite;
   }

   public void setWebSite(String webSite)
   {
      this.webSite = webSite;
   }

}

package by.giava.shoppingadvice.model;

import java.util.List;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product
{
   private static final long serialVersionUID = 1L;
   @JsonProperty("_id")
   private ObjectId id;
   private String name;
   private String brand;
   private String description;
   private String weight;
   private String unityPrice;
   private String price;
   private String image;
   private Market market;
   private List<Image> images;

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

   public ObjectId getId()
   {
      return id;
   }

   public void setId(ObjectId id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Market getMarket()
   {
      return market;
   }

   public void setMarket(Market market)
   {
      this.market = market;
   }

   public List<Image> getImages()
   {
      return images;
   }

   public void setImages(List<Image> images)
   {
      this.images = images;
   }

}

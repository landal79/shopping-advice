package by.giava.shoppingadvice.model;


import java.io.Serializable;

public class Product implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private String marca;
   private String descrizione;
   private String confezione;
   private String prezzoUnita;
   private String prezzo;
   private String imageUri;
   private String externalUri;

   public String getMarca()
   {
      return marca;
   }

   public void setMarca(String marca)
   {
      this.marca = marca;
   }

   public String getDescrizione()
   {
      return descrizione;
   }

   public void setDescrizione(String descrizione)
   {
      this.descrizione = descrizione;
   }

   public String getConfezione()
   {
      return confezione;
   }

   public void setConfezione(String confezione)
   {
      this.confezione = confezione;
   }

   public String getPrezzoUnita()
   {
      return prezzoUnita;
   }

   public void setPrezzoUnita(String prezzoUnita)
   {
      this.prezzoUnita = prezzoUnita;
   }

   public String getPrezzo()
   {
      return prezzo;
   }

   public void setPrezzo(String prezzo)
   {
      this.prezzo = prezzo;
   }

   public String getImageUri()
   {
      return imageUri;
   }

   public void setImageUri(String imageUri)
   {
      this.imageUri = imageUri;
   }

   public String getExternalUri()
   {
      return externalUri;
   }

   public void setExternalUri(String externalUri)
   {
      this.externalUri = externalUri;
   }

}

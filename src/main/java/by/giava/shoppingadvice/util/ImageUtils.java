package by.giava.shoppingadvice.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageUtils
{
   public static boolean toFile(String uri, String fileName)
   {
      BufferedImage image = null;
      try
      {
         URL url = new URL(uri);
         image = ImageIO.read(url);
         ImageIO.write(image, "jpg", new File(fileName));
         return true;
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      return false;
   }

   public static byte[] getBytes(String uri)
   {
      try
      {
         URL url = new URL(uri);
         BufferedImage originalImage = ImageIO.read(url);
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ImageIO.write(originalImage, "jpg", baos);
         baos.flush();
         byte[] imageInByte = baos.toByteArray();
         baos.close();
         return imageInByte;
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return null;

   }
}

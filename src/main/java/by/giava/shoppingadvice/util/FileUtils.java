package by.giava.shoppingadvice.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class FileUtils
{
   public static boolean writeBytes(byte[] content, File file)
   {
      BufferedOutputStream bos;
      try
      {
         bos = new BufferedOutputStream(new FileOutputStream(file));
         bos.write(content);
         bos.flush();
         bos.close();
         return true;
      }
      catch (Exception e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
         return false;
      }

   }
}

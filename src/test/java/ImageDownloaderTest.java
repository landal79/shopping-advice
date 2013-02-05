import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageDownloaderTest
{
   public static void main(String[] args)
   {
      BufferedImage image = null;
      try
      {
         URL url = new URL("http://www.spesain.it/foto/S5001723.jpg");
         image = ImageIO.read(url);
         ImageIO.write(image, "jpg", new File("img/fungo_cardoncello_001.jpg"));
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}

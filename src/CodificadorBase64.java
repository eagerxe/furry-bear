import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;

/**
 *
 * @author miguelhernandez
 */
public class CodificadorBase64 {
    
    public static String imagenACadena (BufferedImage imagen, String tipo){
        
        String imagenString= null;
        ByteArrayOutputStream bos= new ByteArrayOutputStream();
        try{
            Base64.Encoder encoder = Base64.getEncoder();
            ImageIO.write(imagen, tipo, bos);
            byte[] imageBytes = bos.toByteArray();
            
            imagenString = encoder.encodeToString(imageBytes);
            bos.close();
            
        }catch(IOException e){
            System.out.println("No se encontro la imagen");
        }
        return imagenString;
    }
    
    public static BufferedImage cadenaAImagen(String imageString){
        BufferedImage image= null;
        byte[] imageByte;
        try{
            Base64.Decoder decoder = Base64.getDecoder();
            imageByte = decoder.decode(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return image;
    }
    
    
    
    
    public static void main(String[] args) throws IOException {
        BufferedImage img = ImageIO.read(new File("/Users/miguelhernandez/Desktop/AHasB.jpg"));
        BufferedImage newImg;
        
        String imgstr;
        imgstr = imagenACadena(img, "jpg");
        System.out.println(imgstr);
        
        newImg = cadenaAImagen(imgstr);
        ImageIO.write(newImg, "jpg", new File("/Users/miguelhernandez/Desktop/CopyOfTestImage.jpg"));
        
        
        
        }

}








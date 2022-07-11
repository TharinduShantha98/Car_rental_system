package lk.ijse.spring.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileUploadUtil {

    public static void saveFile(String uploadDir, HashMap<String, MultipartFile> stringMultipartFileHashMap) throws IOException {

        Path path = Paths.get(uploadDir);


        System.out.println("=========================");
        System.out.println(path);

        if(!Files.exists(path)){
            Files.createDirectories(path);
        }

        stringMultipartFileHashMap.forEach((key,value) ->{
            System.out.println(key + " " + value);

            try(InputStream inputStream = value.getInputStream()){

                    Path filePath = path.resolve(key);
                    System.out.println(filePath);
                    Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);



            }catch (IOException ioException){
                try {
                    throw  new IOException("could not save image file"+ ioException);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        });
        
        
        
        
        
        
        
        
        
       /* try(InputStream inputStream = multipartFile.getInputStream()){
            for (String s1 : images
                 ) {
                Path filePath = path.resolve(s1);
                System.out.println(filePath);

                Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);

            }

        }catch (IOException ioException){
            throw  new IOException("could not save image file"+ ioException);
        }*/





    }














}

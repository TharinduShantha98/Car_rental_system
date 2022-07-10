package lk.ijse.spring.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class CustomerFileUploadUtil {

    public static void saveFile(String uploadDir, ArrayList<String> images, MultipartFile multipartFile) throws IOException {

        Path path = Paths.get(uploadDir);


        System.out.println("=========================");
        System.out.println(path);

        if(!Files.exists(path)){
            Files.createDirectories(path);
        }

        try(InputStream inputStream = multipartFile.getInputStream()){
            for (String s1 : images
                 ) {
                Path filePath = path.resolve(s1);
                System.out.println(filePath);

                Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);

            }

        }catch (IOException ioException){
            throw  new IOException("could not save image file"+ ioException);
        }





    }














}

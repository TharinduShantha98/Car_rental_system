package lk.ijse.spring.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CustomerFileUploadUtil {

    public static void saveFile(String uploadDir, String license, MultipartFile multipartFile) throws IOException {

        Path path = Paths.get(uploadDir);

        if(!Files.exists(path)){
            Files.createDirectories(path);
        }

        try(InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = path.resolve(license);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);



        }catch (IOException ioException){
            throw  new IOException("could not save image file"+ license,ioException);
        }





    }














}

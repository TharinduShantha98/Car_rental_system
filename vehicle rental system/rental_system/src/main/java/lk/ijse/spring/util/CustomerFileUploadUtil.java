package lk.ijse.spring.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomerFileUploadUtil {

    public static void saveFile(String uploadDir, String license, MultipartFile multipartFile) throws IOException {

        Path path = Paths.get(uploadDir);

        if(!Files.exists(path)){
            Files.createDirectories(path);
        }






    }














}

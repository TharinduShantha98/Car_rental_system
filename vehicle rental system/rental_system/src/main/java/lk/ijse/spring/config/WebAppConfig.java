package lk.ijse.spring.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@ComponentScan("lk.ijse.spring")
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {


    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }


    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(20971520);
        commonsMultipartResolver.setMaxInMemorySize(1048576);
        return commonsMultipartResolver;

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("D:/assets/customer/", registry);
    }

    public  void exposeDirectory(String dirName , ResourceHandlerRegistry registry){

        Path uploadDir = Paths.get(dirName);
        String uploadPath =  uploadDir.toFile().getAbsolutePath();
        if(dirName.startsWith("../"))  dirName = dirName.replace("../","");
        registry.addResourceHandler("/"+"dirName"+"/**").addResourceLocations("file:/"+uploadPath+"/");



    }


}

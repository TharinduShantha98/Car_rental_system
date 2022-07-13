package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.dto.OrdersDto;
import lk.ijse.spring.service.OrderService;
import lk.ijse.spring.util.FileUploadUtil;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/order")
@CrossOrigin
public class OrderController {


    @Autowired
    OrderService orderService;



    @PostMapping()
    public ResponseUtil addOrderDetail(@RequestBody OrdersDto ordersDto){
        boolean b = orderService.addOrder(ordersDto);
        return new ResponseUtil(200, "added order  success",b);

    }

    @PostMapping(value = "upload/image")
     public  ResponseUtil addBankClip(@RequestParam("bankClip") MultipartFile bankClip,
                                      @ModelAttribute("orderId") String orderId) throws IOException {

        String bankClipFileName = StringUtils.cleanPath(Objects.requireNonNull(bankClip.getOriginalFilename()));
        HashMap<String, MultipartFile> storeImage =  new HashMap<>();
        storeImage.put(bankClipFileName,bankClip);

        String uploadDir = "D:/fileServer/order/"+ orderId;
        FileUploadUtil.saveFile(uploadDir,storeImage);
        return new ResponseUtil(200, "added order success",null);

     }


     @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseUtil getOrders(){
         List<OrdersDto> allOrder = orderService.getAllOrder();
         return new ResponseUtil(200, "getAll orders success", allOrder);

     }


     @GetMapping(value = "search", params = "id",produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseUtil searchOrders(@RequestParam("id") String  id){
         System.out.println("hello search");
         OrdersDto ordersDto = orderService.searchOrder(id);
         return new ResponseUtil(200, "search successful ", ordersDto);


     }

     @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseUtil updateOrders(@RequestBody OrdersDto ordersDto ){
         boolean b = orderService.updateOrder(ordersDto);
         return new ResponseUtil(200, "update successful",b);

     }


     @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseUtil deleteOrder(@RequestParam String id){
         boolean b = orderService.deleteOrder(id);
         return new ResponseUtil(200,"delete order successful", b);
     }















}

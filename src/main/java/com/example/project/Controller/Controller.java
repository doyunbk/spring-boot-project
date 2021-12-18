package com.example.project.Controller;

import com.example.project.Model.DTO.OrderDTO;
import com.example.project.Model.Entity.Order;
import com.example.project.Model.Entity.Product;
import com.example.project.Service.OrderService;
import com.example.project.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controller {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){

        return productService.createProduct(product);

    }

    @GetMapping("/all-products")
    public List<Product> getAllProductList(){
        return productService.getAllProductList();
    }

    @GetMapping("/products/")
    public List<Product> getProductsByTimePeriod(){
        LocalDate currentDate = LocalDate.now();
        return productService.getProductsByTimePeriod(currentDate);

    }

    @PostMapping("/order")
    public OrderDTO createOrder(@RequestHeader(value = "X-USER-ID") final long userId, @RequestBody OrderDTO orderDTO){

        long productId = orderDTO.getProductId();
        long investAmt = orderDTO.getInvestAmt();

        return orderService.createOrder(orderDTO, userId, productId, investAmt);
    }

    @GetMapping("/order")
    public List<Order> getOrder(@RequestHeader(value = "X-USER-ID") final long userId){

        return orderService.getOrders(userId);

    }

}

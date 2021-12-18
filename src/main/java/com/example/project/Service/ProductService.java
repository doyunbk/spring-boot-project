package com.example.project.Service;

import com.example.project.Model.Entity.Product;
import com.example.project.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProductList(){
        return productRepository.getAllProducts();
    }

    public List<Product> getProductsByTimePeriod(LocalDate currentDate){
        return productRepository.getProductsByTimePeriod(currentDate);
    }


}

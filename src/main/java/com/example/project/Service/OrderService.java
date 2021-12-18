package com.example.project.Service;

import com.example.project.Exeption.RequestException;
import com.example.project.Model.DTO.OrderDTO;
import com.example.project.Model.Entity.Order;
import com.example.project.Model.Entity.Product;
import com.example.project.Repository.OrderRepository;
import com.example.project.Repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;


    public List<Order> getOrders(long userId){
        List<Order> orderList = orderRepository.getOrderByUserId(userId);
        return orderList;
    }

    public OrderDTO createOrder(OrderDTO orderDTO, long userId, long productId, long investAmt){

        synchronized (this) {
            Product product = validateProduct(orderDTO);

            long noOfInvestors = product.getNoOfInvestors();
            long productTotalInvestmentAmt = product.getTotalInvestmentAmt();
            long productCurrentInvestmentAmt = product.getCurrentInvestmentAmt();

            long investmentAmount = productCurrentInvestmentAmt + investAmt;

            product.setCurrentInvestmentAmt(investmentAmount);
            product.setNoOfInvestors(noOfInvestors + 1);

            if (investmentAmount == productTotalInvestmentAmt) {
                product.setStatus(false);
            }

            orderDTO.setProductId(productId);
            orderDTO.setUserId(userId);
            orderDTO.setInvestAmt(investAmt);
            orderDTO.setTitle(product.getTitle());
            orderDTO.setTotalInvestmentAmt(product.getTotalInvestmentAmt());
            orderDTO.setCreatedAt(LocalDate.now());
            orderDTO.setMessage("성공적으로 투자구매가 완료되었습니다.");
        }

        ModelMapper modelMapper = new ModelMapper();

        Order order = modelMapper.map(orderDTO, Order.class);

        orderRepository.save(order);

        return orderDTO;
    }

    public Product validateProduct(OrderDTO orderDTO){
        long productId = orderDTO.getProductId();
        long amount = orderDTO.getInvestAmt();

        Product product = productRepository.getProductByProductId(productId);

        if(product == null){
            throw new RequestException("구매하시는 상품은 존재하지않습니다.");
        }

        long totalInvestmentAmount = amount + product.getCurrentInvestmentAmt();

        if(product.getStatus() == false){
            throw new RequestException("이 상품은 품절입니다.");
        } else if(totalInvestmentAmount > product.getTotalInvestmentAmt()){
            throw new RequestException("이 상품의 총 투자금액이 초과합니다.");
        }

        return product;
    }

}

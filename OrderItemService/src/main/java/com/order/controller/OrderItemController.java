package com.order.controller;

import com.order.ifc.OrderItemRepoIfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/v1")
@EnableSwagger2
public class OrderItemController {
    @Autowired
    OrderItemRepoIfc orderItemRepoIfc;

    @GetMapping("/getOrderItem")
    public OrderItem getOrderItem(@RequestParam("productCode") int productCode)
    {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductCode(productCode);
        orderItem.setProductName("Invalid");
        orderItem.setQuantity(0.0);

        return orderItemRepoIfc.findById(productCode).orElse(orderItem);
    }

    @PostMapping("/addOrderItem")
    public OrderItem addOrderItem(@RequestBody OrderItem order)
    {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductName(order.getProductName());
        orderItem.setQuantity(order.getQuantity());
        return orderItemRepoIfc.save(orderItem);
    }

}

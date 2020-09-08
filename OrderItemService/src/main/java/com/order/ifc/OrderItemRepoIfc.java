package com.order.ifc;

import com.order.controller.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepoIfc extends JpaRepository<OrderItem, Integer> {
}

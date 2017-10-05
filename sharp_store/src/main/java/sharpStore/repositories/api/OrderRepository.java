package sharpStore.repositories.api;

import sharpStore.entities.Order;
import java.util.List;

public interface OrderRepository {

    void addOrder(Order order);

    List<Order> findAllOrders();

    Order findOrderById(Long id);

    void editOrder(Order order);
}

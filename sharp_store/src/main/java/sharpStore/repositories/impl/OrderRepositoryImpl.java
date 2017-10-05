package sharpStore.repositories.impl;

import sharpStore.entities.Order;
import sharpStore.repositories.api.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    private static OrderRepositoryImpl orderRepository;

    private List<Order> orders;

    private Long currentIndex;

    private OrderRepositoryImpl() {
        this.orders = new ArrayList<>();
        this.currentIndex = 1L;
    }

    public static OrderRepository getInstance() {
        if (orderRepository == null) {
            orderRepository = new OrderRepositoryImpl();
        }

        return orderRepository;
    }

    @Override
    public void addOrder(Order order) {
        order.setId(this.currentIndex++);
        this.orders.add(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return this.orders;
    }

    @Override
    public Order findOrderById(Long id) {
        Order order = null;
        Optional<Order> candidateOrder = this.orders.stream()
                .filter(o -> o.getId().equals(id)).findAny();
        if (candidateOrder.isPresent()) {
            order = candidateOrder.get();
        }

        return order;
    }

    @Override
    public void editOrder(Order order) {
        Integer orderIndex = this.getOrderIndex(order);
        if (orderIndex != null) {
            this.orders.set(orderIndex, order);
        }
    }

    private Integer getOrderIndex(Order order) {
        Integer orderIndex = null;
        for (int i = 0; i < this.orders.size(); i++) {
            Order currOrder = this.orders.get(i);
            if (currOrder.getId().equals(order.getId())) {
                orderIndex = i;
                break;
            }
        }
        return orderIndex;
    }
}

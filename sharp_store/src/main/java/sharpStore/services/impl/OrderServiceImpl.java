package sharpStore.services.impl;

import sharpStore.entities.Order;
import sharpStore.models.bindingModels.AddOrder;
import sharpStore.models.viewModels.ShowOrder;
import sharpStore.repositories.impl.OrderRepositoryImpl;
import sharpStore.services.api.OrderService;
import sharpStore.utils.MapperUtil;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Local(OrderService.class)
public class OrderServiceImpl implements OrderService {

    @Override
    public void addOrder(AddOrder addOrder) {
        if (addOrder != null) {
            Order order = MapperUtil.getInstance().getModelMapper()
                    .map(addOrder, Order.class);
            OrderRepositoryImpl.getInstance().addOrder(order);
        }
    }

    @Override
    public List<ShowOrder> findAllOrders() {
        List<Order> orders = OrderRepositoryImpl.getInstance().findAllOrders();
        List<ShowOrder> showOrders = MapperUtil.getInstance()
                .convertAll(orders, ShowOrder.class);
        return showOrders;
    }

    @Override
    public ShowOrder findOrderById(Long id) {
        ShowOrder showOrder = null;

        if (id != null) {
            Order order = OrderRepositoryImpl.getInstance().findOrderById(id);
            if (order != null) {
                showOrder = MapperUtil.getInstance().getModelMapper()
                        .map(order, ShowOrder.class);
            }
        }

        return showOrder;
    }

    @Override
    public void editOrder(ShowOrder editOrder) {
        if (editOrder != null) {
            Order order = MapperUtil.getInstance().getModelMapper()
                    .map(editOrder, Order.class);
            OrderRepositoryImpl.getInstance().editOrder(order);
        }
    }
}

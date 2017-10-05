package sharpStore.services.api;

import sharpStore.models.bindingModels.AddOrder;
import sharpStore.models.viewModels.ShowOrder;

import java.util.List;

public interface OrderService {

    void addOrder(AddOrder addOrder);

    List<ShowOrder> findAllOrders();

    ShowOrder findOrderById(Long id);

    void editOrder(ShowOrder editOrder);
}

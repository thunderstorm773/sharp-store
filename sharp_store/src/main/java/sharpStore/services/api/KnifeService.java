package sharpStore.services.api;

import sharpStore.models.bindingModels.AddKnife;
import sharpStore.models.viewModels.ShowKnife;
import java.util.List;

public interface KnifeService {

    void addKnife(AddKnife addKnife);

    List<ShowKnife> findAllKnives();

    List<ShowKnife> findKnivesByName(String knifeName);

    ShowKnife findKnifeById(Long id);

    void editKnife(ShowKnife showKnife);

    void deleteKnife(Long id);
}

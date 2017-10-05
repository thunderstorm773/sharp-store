package sharpStore.services.impl;

import sharpStore.entities.Knife;
import sharpStore.models.bindingModels.AddKnife;
import sharpStore.models.viewModels.ShowKnife;
import sharpStore.repositories.impl.KnifeRepositoryImpl;
import sharpStore.services.api.KnifeService;
import sharpStore.utils.MapperUtil;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local(KnifeService.class)
public class KnifeServiceImpl implements KnifeService {

    @Override
    public void addKnife(AddKnife addKnife) {
        if (addKnife != null) {
            Knife knife = MapperUtil.getInstance().getModelMapper()
                    .map(addKnife, Knife.class);
            KnifeRepositoryImpl.getInstance().addKnife(knife);
        }
    }

    @Override
    public List<ShowKnife> findAllKnives() {
        List<Knife> knives = KnifeRepositoryImpl.getInstance().findAllKnives();
        List<ShowKnife> showKnives = MapperUtil.getInstance()
                .convertAll(knives, ShowKnife.class);
        return showKnives;
    }

    @Override
    public List<ShowKnife> findKnivesByName(String knifeName) {
        List<Knife> knives = new ArrayList<>();
        if (knifeName != null && !knifeName.isEmpty()) {
            knives = KnifeRepositoryImpl.getInstance().findKnivesByName(knifeName);
        }

        List<ShowKnife> showKnives = MapperUtil.getInstance()
                .convertAll(knives, ShowKnife.class);
        return showKnives;
    }

    @Override
    public ShowKnife findKnifeById(Long id) {
        ShowKnife showKnife = null;
        if (id != null) {
            Knife knife = KnifeRepositoryImpl.getInstance().findKnifeById(id);
            if (knife != null) {
                showKnife = MapperUtil.getInstance().getModelMapper()
                        .map(knife, ShowKnife.class);
            }
        }

        return showKnife;
    }

    @Override
    public void editKnife(ShowKnife editKnife) {
        if (editKnife != null) {
            Knife knife = MapperUtil.getInstance().getModelMapper()
                    .map(editKnife, Knife.class);
            KnifeRepositoryImpl.getInstance().editKnife(knife);
        }
    }

    @Override
    public void deleteKnife(Long id) {
        if (id != null) {
            KnifeRepositoryImpl.getInstance().deleteKnife(id);
        }
    }
}

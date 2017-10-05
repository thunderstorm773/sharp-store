package sharpStore.repositories.api;

import sharpStore.entities.Knife;
import java.util.List;

public interface KnifeRepository {

    void addKnife(Knife knife);

    List<Knife> findAllKnives();

    List<Knife> findKnivesByName(String knifeName);

    Knife findKnifeById(Long id);

    void editKnife(Knife knife);

    void deleteKnife(Long id);
}

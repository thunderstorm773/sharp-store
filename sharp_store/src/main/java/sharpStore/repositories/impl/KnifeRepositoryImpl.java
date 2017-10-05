package sharpStore.repositories.impl;

import sharpStore.entities.Knife;
import sharpStore.repositories.api.KnifeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class KnifeRepositoryImpl implements KnifeRepository {

    private static KnifeRepository knifeRepository;

    private List<Knife> knives;

    private long currentIndex;

    private KnifeRepositoryImpl() {
        this.knives = new ArrayList<>();
        this.currentIndex = 1L;
    }

    public static KnifeRepository getInstance() {
        if (knifeRepository == null) {
            knifeRepository = new KnifeRepositoryImpl();
        }

        return knifeRepository;
    }

    @Override
    public void addKnife(Knife knife) {
        knife.setId(this.currentIndex++);
        this.knives.add(knife);
    }

    @Override
    public List<Knife> findAllKnives() {
        return this.knives;
    }

    @Override
    public List<Knife> findKnivesByName(String knifeName) {
        return this.knives.stream()
                .filter(k -> k.getName().toLowerCase()
                        .contains(knifeName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Knife findKnifeById(Long id) {
        Knife knife = null;
        Optional<Knife> candidateKnife = this.knives.stream().
                filter(k -> k.getId().equals(id)).findAny();
        if (candidateKnife.isPresent()) {
            knife = candidateKnife.get();
        }

        return knife;
    }

    @Override
    public void editKnife(Knife knife) {
        Integer knifeIndex = this.getKnifeIndex(knife);
        if (knifeIndex != null) {
            this.knives.set(knifeIndex, knife);
        }
    }

    @Override
    public void deleteKnife(Long id) {
        this.knives.removeIf(k -> k.getId().equals(id));
    }

    private Integer getKnifeIndex(Knife knife) {
        Integer knifeIndex = null;
        for (int i = 0; i < this.knives.size(); i++) {
            Knife currKnife = this.knives.get(i);
            if (currKnife.getId().equals(knife.getId())) {
                knifeIndex = i;
                break;
            }
        }
        return knifeIndex;
    }
}

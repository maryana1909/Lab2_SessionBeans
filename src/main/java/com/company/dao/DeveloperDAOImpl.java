package com.company.dao;

import com.company.entity.Developer;
import lombok.NonNull;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class DeveloperDAOImpl implements DeveloperDAO{
    private final List<Developer> developerList;

    public DeveloperDAOImpl() {
        this.developerList = new ArrayList<>();;
    }

    @Override
    public void add(@NonNull Developer developer) {
        if(!developerList.contains(developer)) {
            developerList.add(developer);
        }
    }

    @Override
    public boolean remove(@NonNull Developer developer) {
        return developerList.remove(developer);
    }

    @Override
    public Optional<Developer> get(@NonNull String name) {
        return developerList.stream().filter(developer ->
                developer.getName().equals(name)).findAny();
    }

    @Override
    public List<Developer> getAll() {
        return new ArrayList<>(developerList);
    }

    @Override
    public void addAll(@NonNull List<Developer> bowlingList) {
        this.developerList.addAll(bowlingList);
    }

    @Override
    public boolean isEmpty() {
        return developerList.isEmpty();
    }
}

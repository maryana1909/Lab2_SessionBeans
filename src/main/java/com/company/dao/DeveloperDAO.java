package com.company.dao;

import com.company.entity.Developer;
import lombok.NonNull;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface DeveloperDAO {
    void add(@NonNull Developer bowling);
    boolean remove(@NonNull Developer bowling);
    Optional<Developer> get(@NonNull String name);
    List<Developer> getAll();
    void addAll(@NonNull List<Developer> bowlingList);
    boolean isEmpty();
}

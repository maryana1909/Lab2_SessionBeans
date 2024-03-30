package com.company.service;

import com.company.entity.Developer;

import javax.ejb.Local;
import java.util.List;

@Local
public interface InitDataService {
    List<Developer> initDevelopers();
}

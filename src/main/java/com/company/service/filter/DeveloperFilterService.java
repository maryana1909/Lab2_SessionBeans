package com.company.service.filter;

import com.company.entity.Developer;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DeveloperFilterService {
    List<Developer> filter(String position);
}

package com.company.service.find;

import com.company.entity.Developer;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DeveloperFindService {
    List<Developer> find();
}

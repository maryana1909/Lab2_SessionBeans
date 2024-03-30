package com.company.service.filter;

import com.company.dao.DeveloperDAO;
import com.company.entity.Developer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class DeveloperFilterImpl implements DeveloperFilterService{
    @EJB
    private DeveloperDAO developerDAO;

    @Override
    public List<Developer> filter(String position) {
        return developerDAO.getAll().stream().filter(developer ->
                developer.getPosition().equals(position)).collect(Collectors.toList());
    }

}

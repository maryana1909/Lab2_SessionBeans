package com.company.service.find;

import com.company.dao.DeveloperDAO;
import com.company.entity.Developer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DeveloperFindServiceImpl implements DeveloperFindService {
    @EJB
    private DeveloperDAO developerDAO;

    @Override
    public List<Developer> find() {
        List<Developer> developerList = developerDAO.getAll();
        Developer maxSalaryDeveloper = developerList.get(0);
        for (Developer developer : developerDAO.getAll()) {
            if (developer.getSalary() >= maxSalaryDeveloper.getSalary())
                maxSalaryDeveloper = developer;
        }
        List<Developer> finalList = new ArrayList<>();
        for(Developer developer : developerDAO.getAll()){
            if(maxSalaryDeveloper.getSalary() == developer.getSalary()){
                finalList.add(developer);
            }
        }
        return finalList;
    }
}

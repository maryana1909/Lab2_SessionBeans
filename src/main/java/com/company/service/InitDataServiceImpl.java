package com.company.service;

import com.company.dao.DeveloperDAO;
import com.company.entity.Developer;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class InitDataServiceImpl implements InitDataService{
    @EJB
    private DeveloperDAO developerDAO;

    @PostConstruct
    public void postConstruct() {
        List<Developer> developerList = initDevelopers();
        this.developerDAO.addAll(developerList);
    }

    @Override
    public List<Developer> initDevelopers() {
        Developer developer = new Developer("Иванов Иван Иванович", "Вся жизнь",
                "Java Developer", "Java", 1500);
        Developer developer2 = new Developer("Игорев Игорь Иванович", "2 года",
                "Python Developer", "Python", 1000);
        Developer developer3 = new Developer("Челяев Арсен Мусугалиев", "1 месяц",
                "C# Developer", "C#", 500);

        List<Developer> developerList = new ArrayList<>();
        developerList.add(developer);
        developerList.add(developer2);
        developerList.add(developer3);

        return developerList;
    }
}

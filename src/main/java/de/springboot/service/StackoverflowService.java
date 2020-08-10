package de.springboot.service;

import de.springboot.model.StackoverflowWebsite;
import de.springboot.persistance.StackoverflowWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class StackoverflowService {
    @Autowired
    private StackoverflowWebsiteRepository repository;

//    private static List<StackoverflowWebsite> items = new ArrayList<>();
//    static {
//        items.add(new StackoverflowWebsite("stackoverflow","http://stackoverflow.com","http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico", "Stack Overflow","For programmers"));
//        items.add(new StackoverflowWebsite("stackoverflowru","http://ru.stackoverflow.com","http://cdn.sstatic.net/Sites/ru/img/favicon.ico", "Stack Overflow Russia","Для программистов"));
//
//
//    }
/*
** should start with this method just ones to write something to db
    @PostConstruct
    public void init() {
        repository.saveAll(items);
    }

 */
    public List<StackoverflowWebsite> findAll(){
        return repository.findAll();
    }
}

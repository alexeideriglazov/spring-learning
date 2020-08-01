package de.springboot.service;

import de.springboot.model.StackoverflowWebsite;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StackoverflowService {
    private static List<StackoverflowWebsite> items = new ArrayList<>();
    static {
        items.add(new StackoverflowWebsite("stackoverflow","http://stackoverflow.com","http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico", "Stack Overflow","For programmers"));
        items.add(new StackoverflowWebsite("stackoverflowru","http://ru.stackoverflow.com","http://cdn.sstatic.net/Sites/ru/img/favicon.ico", "Stack Overflow Russia","Для программистов"));

        
    }

    public List<StackoverflowWebsite> findAll(){
        return items;
    }
}

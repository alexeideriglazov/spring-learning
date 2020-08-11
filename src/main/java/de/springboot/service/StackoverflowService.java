package de.springboot.service;

import com.google.common.collect.ImmutableList;
import de.springboot.model.SiteDto;
import de.springboot.model.StackoverflowWebsite;
import de.springboot.persistance.StackoverflowWebsiteRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StackoverflowService {
    @Autowired
    private StackoverflowWebsiteRepository repository;
    @Autowired
    private StackExchangeClient stackExchangeClient;

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

    public List<StackoverflowWebsite> findAll() {
        return stackExchangeClient.getSites().stream()
                .map(this::toStackoverflowWebsite)
                .filter(this::ignoreMeta)
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
    }

    private boolean ignoreMeta(@NonNull StackoverflowWebsite stackoverflowWebsite) {
        return !stackoverflowWebsite.getId().startsWith("meta");
    }

    private StackoverflowWebsite toStackoverflowWebsite(@NonNull SiteDto input) {
        return new StackoverflowWebsite(
                input.getSite_url().substring(8, input.getSite_url().length() - 4),
                input.getSite_url(),
                input.getFavicon_url(),
                input.getName(),
                input.getAudience());
    }

    //    public List<StackoverflowWebsite> findAll(){
//        return repository.findAll();
//    }
}

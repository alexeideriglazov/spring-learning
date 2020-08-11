package de.springboot.web;

import com.google.common.collect.ImmutableList;
import de.springboot.model.StackoverflowWebsite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StackoverflowControllerTestIT {
    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Autowired
    MongoTemplate mongoTemplate;

    @Before
    public void before() {
        mongoTemplate.dropCollection(StackoverflowWebsite.class);
        mongoTemplate.save(new StackoverflowWebsite("website1", "website", "title", "icon", "description"));
        mongoTemplate.save(new StackoverflowWebsite("website2", "website", "title", "icon", "description"));
    }

    @Test
    public void testGetListOfProviders() {
        //test
        ResponseEntity<List<StackoverflowWebsite>> responseEntity = testRestTemplate.exchange("http://localhost:8080/api/stackoverflow", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<StackoverflowWebsite>>() {
                });
        List<StackoverflowWebsite> actualList = responseEntity.getBody();
        //validate
        assertThat(actualList.size(), is(2));
        List<String> actualIds = actualList.stream()
                .map(stackoverflowWebsite -> stackoverflowWebsite.getId())
                .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
        assertThat(actualIds, containsInAnyOrder("website1", "website2"));
    }

}
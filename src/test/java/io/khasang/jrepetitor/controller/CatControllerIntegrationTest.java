package io.khasang.jrepetitor.controller;

import io.khasang.jrepetitor.entity.Cat;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class CatControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/cat";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get";
    private static final String DELETE = "/delete";
    private static final String ALL = "/all";
    private static final String UPDATE = "/update";

    @Test
    public void addCatAndCheck() {
        Cat cat = createCat();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Cat> entity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals("OK", entity.getStatusCode().getReasonPhrase());

        Cat receivedCat = entity.getBody();
        assertNotNull(receivedCat);

        deleteFromDB(cat);
    }

    @Test
    public void deleteCat() {
        Cat cat = createCat();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Cat> responseEntity = template.exchange(
                ROOT + DELETE + "?id={id}",
                HttpMethod.DELETE,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals(200, responseEntity.getStatusCodeValue());

        Cat deletedCat = responseEntity.getBody();
        assertNotNull(deletedCat);

        ResponseEntity<Cat> responseForDeleteCat = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                deletedCat.getId()
        );

        assertEquals(200, responseForDeleteCat.getStatusCodeValue());

        assertNull(responseForDeleteCat.getBody());
    }

    @Test
    public void getAllCats() {
        Cat firstCat = createCat();
        Cat secondCat = createCat();

        RestTemplate template = new RestTemplate();

        ResponseEntity<List<Cat>> responseEntity = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cat>>() {
                }
        );

        List<Cat> list = responseEntity.getBody();
        assertNotNull(list.get(0));
        assertNotNull(list.get(1));

        list.forEach(cat -> {
            if (cat.getId() == firstCat.getId()
                    || cat.getId() == secondCat.getId()) {
                deleteFromDB(cat);
            }
        });
    }

    @Test
    public void updateCat() {
        Cat preCat = createCat();
        Cat postCat = new Cat();
        postCat.setId(preCat.getId());
        postCat.setName("Ryjik");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Cat> entity = new HttpEntity<>(postCat, headers);

        RestTemplate template = new RestTemplate();

        Cat receivedCat = template.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                entity,
                Cat.class
        ).getBody();

        assertNotNull(receivedCat);
        assertEquals(preCat.getId(), postCat.getId());
        assertNotEquals(preCat.getName(), postCat.getName());

        deleteFromDB(postCat);
    }

    private Cat deleteFromDB(Cat cat) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Cat> responseEntity = template.exchange(
                ROOT + DELETE + "?id={id}",
                HttpMethod.DELETE,
                null,
                Cat.class,
                cat.getId()
        );

        return responseEntity.getBody();
    }

    private Cat createCat() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Cat cat = prefillCat();

        HttpEntity<Cat> entity = new HttpEntity<>(cat, headers);

        RestTemplate template = new RestTemplate();

        Cat receivedCat = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Cat.class
        ).getBody();

        assertNotNull(receivedCat.getName());
        assertEquals(cat.getName(), receivedCat.getName());

        return receivedCat;
    }

    private Cat prefillCat() {
        Cat cat = new Cat();
        cat.setName("Barsik");

        return cat;
    }
}
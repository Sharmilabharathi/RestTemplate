package com.example.springbootresttemplate.controller;

import com.example.springbootresttemplate.model.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author Sharmila
 */
@RestController
public class RestTemplateController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/template/getBookDetails",method = RequestMethod.GET)
    public String getBookDetailList(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        return restTemplate.exchange("http://localhost:8083/getBookDetails",
                HttpMethod.GET,entity,String.class).getBody();
    }

    @RequestMapping(value = "/template/addBookDetails",method = RequestMethod.POST)
    public String addBookDetails(@RequestBody BookDetails bookDetails   ){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<BookDetails> entity = new HttpEntity<>(bookDetails,httpHeaders);

        return restTemplate.exchange("http://localhost:8083/addBookDetails",
                HttpMethod.POST,entity,String.class).getBody();
    }

    @RequestMapping(value = "/template/updateBookDetails/{bookId}",method = RequestMethod.PUT)
    public String updateBookDetails(@RequestBody BookDetails bookDetails, @PathVariable Integer bookId){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<BookDetails> entity = new HttpEntity<>(bookDetails,httpHeaders);

        return restTemplate.exchange("http://localhost:8083/updateBookDetails/"+bookId,
                HttpMethod.PUT,entity,String.class).getBody();
    }

    @RequestMapping(value = "/template/deleteBookDetails/{bookId}",method = RequestMethod.DELETE)
    public String deleteBookDetails(@PathVariable Integer bookId){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<BookDetails> entity = new HttpEntity<>(httpHeaders);

        return restTemplate.exchange("http://localhost:8083/deleteBookDetails/"+bookId,
                HttpMethod.DELETE,entity,String.class).getBody();
    }
}

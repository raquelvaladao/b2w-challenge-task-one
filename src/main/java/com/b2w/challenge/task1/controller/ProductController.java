package com.b2w.challenge.task1.controller;


import com.b2w.challenge.task1.controller.response.BaseController;
import com.b2w.challenge.task1.model.Product;
import com.b2w.challenge.task1.service.OrderAPIService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.*;

@RestController
@RequestMapping("/challenge-backend")
public class ProductController extends BaseController<Product> {

    @Autowired
    private OrderAPIService orderAPIService;

    @GetMapping(path = "/item")
    public ResponseEntity<List<Product>> listProductsInRange(
            @RequestParam(name = "begindate", required = false) String beginDate,
            @RequestParam(name = "finaldate", required = false) String finalDate
    ) throws JsonProcessingException, ParseException {

        List<Product> products = orderAPIService.jsonMapper();
        try{
            Date intervalStart = parseStringToDate(beginDate);
            Date intervalEnd = parseStringToDate(finalDate);
            List<Product> filteredProducts = products
                    .stream()
                    .filter(product ->
                            isWithinRange(product.getDate(), intervalStart, intervalEnd))
                    .collect(toList());
            return answerListOfItems(filteredProducts);
        } catch (Exception e){
            return answerEmptyList();
        }
    }

    boolean isWithinRange(Date givenDate, Date begin, Date end) {
        return (givenDate.before(end) && givenDate.after(begin));
    }

    private Date parseStringToDate(String inputDate) throws ParseException{
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(inputDate);
        return date;
    }
}

// Author: Loc Ha
package com.onward.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onward.app.entities.LineItem;
import com.onward.app.services.LineItemService;
import java.util.List;

/**
 * LineItemController class that exposes LineItem services as RESTful endpoints.
 */
@RestController
@RequestMapping("/lineitem")
public class LineItemController 
{
    @Autowired
    private LineItemService lineitemService;

   
    
    // Retrieves all line items
    @GetMapping("/getlineitems")
    public List<LineItem> listAll() 
    {
        return lineitemService.listAll();
    }

    @CrossOrigin
    @PostMapping(value = "/newlineitem", consumes = "application/json")
    // Creates a new line item
    public LineItem create(@RequestBody LineItem lineItem) 
    {
        return lineitemService.saveLI(lineItem);
    }
//TODO Implement update and delete

}
package com.mapsa.onetoonewithsharedprimarykeysample.controller.singleTable;

import com.mapsa.onetoonewithsharedprimarykeysample.SingleTableParame;
import com.mapsa.onetoonewithsharedprimarykeysample.model.singleTable.Pen;
import com.mapsa.onetoonewithsharedprimarykeysample.service.singleTable.PenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pen")
public class PenController {
    @Autowired
    private PenService service;


    @PostMapping("save")
    public void save(@RequestBody SingleTableParame parame) {
        service.save(parame.getParam(), parame.getName());
    }

    @GetMapping("all")
    public List<Pen> getAll() {
        return service.getAll();
    }
}

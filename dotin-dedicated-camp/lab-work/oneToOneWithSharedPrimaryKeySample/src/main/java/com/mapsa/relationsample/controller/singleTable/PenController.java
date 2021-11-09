package com.mapsa.relationsample.controller.singleTable;

import com.mapsa.relationsample.param.SingleTableParame;
import com.mapsa.relationsample.model.singleTable.Pen;
import com.mapsa.relationsample.service.singleTable.PenService;
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

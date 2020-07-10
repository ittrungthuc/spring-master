package com.trungthuc.controllers;

import com.trungthuc.repositories.CsvDataRepository;
import com.trungthuc.repositories.SqlExecFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvApi {

    @Autowired
   private CsvDataRepository csvDataRepository;

    @Autowired
    private SqlExecFileRepository sqlExecFileRepository;

    @RequestMapping(value = "/exec/csv")
    public String  execCsv(){
        String patch = "D:\\\\mysql\\\\data.csv";
        String result =   sqlExecFileRepository.execCmdOS(patch);
     //   sqlExecFileRepository.ping();
        String patch1 = "D";
        return result;
    }
}

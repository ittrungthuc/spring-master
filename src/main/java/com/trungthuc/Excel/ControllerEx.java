package com.trungthuc.Excel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ControllerEx {


   public static List<Employee> getAll=new ArrayList<>();

   // mảng dữ liệu giả định
   public static void fetchD() {
        for (int i=1;i<=100;i++){
            getAll.add(new Employee("data"+i,new Date(),(i+1)*2));
            System.out.println("i = " + i);        }
    }

    // dường dẫn đễ tải file
    @GetMapping(value = "/dowload")
    public View dowload(Model mm){
        fetchD();
        mm.addAttribute("employes",getAll);
        return new Excel();
    }

}

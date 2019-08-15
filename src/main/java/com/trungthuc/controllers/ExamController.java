package com.trungthuc.controllers;

import com.trungthuc.domains.Exam;
import com.trungthuc.domains.Question;
import com.trungthuc.dtos.ExamQuestioDTO;
import com.trungthuc.services.ExamService;
import com.trungthuc.spec.ExamSpec;
import com.trungthuc.utils.DTOUtils;
import com.trungthuc.utils.PaginationUtil;
import com.trungthuc.utils.WizardConstant;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class ExamController extends AbtractController {
    @Autowired
    ExamService examService;

    ModelMapper mapper =new ModelMapper();




    @GetMapping(value = "/exam/{id}")
    public ExamQuestioDTO question(@PathVariable("id") int id){
        Exam exam =examService.findById(id).orElse(null);
        return mapper.map(exam,ExamQuestioDTO.class);
    }

    @PostMapping(value = "/exam")
    public Exam exam(@Valid @RequestBody  Exam exam) {

        return examService.save(exam);
    }
    @PutMapping(value = "/exam")
    public Exam update(@Valid @RequestBody  Exam exam) {
        System.out.println(" = " +"save oke");
        return examService.save(exam);
    }

    @GetMapping(value = "/exam")
    public Page<ExamQuestioDTO> page(@RequestParam HashMap<String,Object> res){

        int page = res.get("page") ==null ? WizardConstant.PAGE_DEFAULT : Integer.parseInt(res.get("page").toString());
        int size = res.get("size") ==null ? WizardConstant.SIZE_DEFAULT : Integer.parseInt(res.get("size").toString());

        String name =  this.StringcheckHepper(res,"name");

        Specification<Exam> spec=Specification.where(ExamSpec.defaultWhere());
       if (!"".equals(name)){
            spec=spec.and(ExamSpec.findByName(name));
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Exam> exams =examService.findAll(spec,pageable );

      return  DTOUtils.mapPage(exams,ExamQuestioDTO.class) ;

       /* java.lang.reflect.Type targetListType = new TypeToken<Page<ExamQuestioDTO>>() {}.getType();*/
    }
}

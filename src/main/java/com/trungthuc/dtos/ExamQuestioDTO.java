package com.trungthuc.dtos;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class ExamQuestioDTO {
    private int id;
    private String name;
    private Instant startAt;
    private Instant endAt;
   /* private List<QuestionInfoDTO> questions;*/
}

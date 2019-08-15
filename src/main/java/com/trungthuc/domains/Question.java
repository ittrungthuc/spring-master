package com.trungthuc.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_QUESTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question extends AbtractDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TITLE")
    @NotNull
    private String title;

    @Column(name = "CONTENT")
    @NotNull
    private String content;

    @Column(name = "ANWSER")
    private String anwser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXAM_ID",referencedColumnName="id")
    @JsonIgnore
    private Exam exam;


}

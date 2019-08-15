package com.trungthuc.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_EXAM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Exam extends AbtractDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME",unique = true)
    @Size(min = 10,max = 100,message = "min => 10")
    @NotNull
    private String name;

    @Column(name = "START_AT")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private Instant startAt;

    @Column(name = "END_AT")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private Instant endAt;

    @Column(name = "IS_USE",columnDefinition = "TINYINT(1) default 1")
    private boolean isUse=false;


    @OneToMany(mappedBy = "exam",fetch =FetchType.LAZY, orphanRemoval = true)
    private List<Question> questions =new ArrayList<>();
    public void add(Question question){
        this.questions.add(question);
    }
    public void remove(Question question){
        this.questions.remove(question);
    }




}

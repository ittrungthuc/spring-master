package com.trungthuc.domains;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.*;
import java.util.Date;
@Data
@ToString
public class Student {

    @NotNull(message = "Tên không được để trống")
    @Size(min = 3,max = 250,message = "Tên có độ dài thừ 2 -250 kí tự")
    private String name;

    @Email(message = "Vui lòng nhập đúng email của bạn")
    private String email;

    @Min(value = 18,message = "Tuổi không nhỏ hơn 18")
    @Max(value = 80,message = " Không chấp nhận người quá 80 tuổi")
    private int age;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}",message = "Ngày tháng đing dạng yyy-MM-dd")
    @Past(message = "Ngày sinh là 1 ngày trong quá khứ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;

    @Positive(message = "Số năm kinh nghiệm >=0")
    private int exprence;

}

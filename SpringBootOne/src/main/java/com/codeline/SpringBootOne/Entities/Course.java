package com.codeline.SpringBootOne.Entities;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class Course {

    Integer id;
    String courseName;
    String category;
    Integer durationHour;
    Date createDate;
    Date updateDate;
    Boolean isActive;

}

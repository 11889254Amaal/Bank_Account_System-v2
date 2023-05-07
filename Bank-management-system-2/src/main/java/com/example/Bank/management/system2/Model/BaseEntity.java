package com.example.Bank.management.system2.Model;


import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

public class BaseEntity {
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Muscat")
    Date createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Muscat")
    Date updatedDate;
    Boolean isActive;
}

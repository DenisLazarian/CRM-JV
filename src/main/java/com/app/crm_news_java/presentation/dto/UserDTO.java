package com.app.crm_news_java.presentation.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    private String name;
    private String surnames;
    private String age;

    private String password;

    private String email;

    private Date born;
    private Date lastModifiedDate;

    private List<NewDTO> articles;
}

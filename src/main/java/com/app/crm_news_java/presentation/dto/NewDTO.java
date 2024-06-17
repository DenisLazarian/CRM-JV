package com.app.crm_news_java.presentation.dto;

import com.app.crm_news_java.persist.entities.UserEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class NewDTO {
    private Long id;

    private String title;

    private String subTitle;

    private String text;

    private Date datePublished;

    private Date lastModified;

    private UserEntity author;
}

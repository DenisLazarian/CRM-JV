package com.app.crm_news_java.persist.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
@Getter
@Setter
public class NewEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subTitle;

    private String text;

    private Date datePublished;

    private Date lastModified;

    @ManyToOne(targetEntity = UserEntity.class)
    private UserEntity author;

}

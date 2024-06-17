package com.app.crm_news_java.persist.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String surnames;

    private String age;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Column(nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    private Date born;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @OneToMany(targetEntity = NewEntity.class, fetch = FetchType.LAZY, mappedBy = "author")
    private List<NewEntity> articles;
}

package com.app.crm_news_java.persist.repositories;

import com.app.crm_news_java.persist.entities.NewEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface INewRepository extends CrudRepository<NewEntity, Long> {

//    @Query("SELECT n FROM NewEntity n")
//    List<NewEntity> findNews();

    @Query("SELECT n FROM NewEntity n")
    List<NewEntity> findNewEntities();

    Optional<NewEntity> findNewEntityById(Long id);



}

package com.app.crm_news_java.persist.repositories;

import com.app.crm_news_java.persist.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String name);

    @Query("SELECT u FROM UserEntity u")
    List<UserEntity> findUsers();

    @Query("SELECT u FROM UserEntity u WHERE u.id = ?1")
    Optional<UserEntity> getById(Long id);

}

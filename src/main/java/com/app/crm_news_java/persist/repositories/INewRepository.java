package com.app.crm_news_java.persist.repositories;

import com.app.crm_news_java.persist.entities.NewEntity;
import org.springframework.data.repository.CrudRepository;

public interface INewRepository extends CrudRepository<NewEntity, Long> {


}

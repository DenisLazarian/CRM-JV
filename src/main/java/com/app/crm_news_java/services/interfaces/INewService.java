package com.app.crm_news_java.services.interfaces;

import com.app.crm_news_java.presentation.dto.NewDTO;
import com.app.crm_news_java.presentation.dto.UserDTO;

import java.util.List;

public interface INewService {

    List<NewDTO> findAll();

    NewDTO create(NewDTO userDTO);

    UserDTO getAuthUser(Long id);

    NewDTO findById(Long id);

    NewDTO update(NewDTO userDTO, Long id);

    String delete(Long id);

}

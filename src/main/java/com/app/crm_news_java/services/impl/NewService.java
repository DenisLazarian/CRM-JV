package com.app.crm_news_java.services.impl;


import com.app.crm_news_java.persist.entities.NewEntity;
import com.app.crm_news_java.persist.entities.UserEntity;
import com.app.crm_news_java.persist.repositories.INewRepository;
import com.app.crm_news_java.presentation.dto.NewDTO;
import com.app.crm_news_java.presentation.dto.UserDTO;
import com.app.crm_news_java.services.interfaces.INewService;
import com.app.crm_news_java.services.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewService implements INewService {

    @Autowired
    private INewRepository newRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserService userService;

    @Override
    public List<NewDTO> findAll() {
        return this.newRepository.findNewEntities()
                .stream()
                .map(news -> modelMapper.map(news, NewDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public NewDTO create(NewDTO newDTO) {
        try{
            NewEntity article = modelMapper.map(newDTO, NewEntity.class);
            article.setDatePublished(new Date());
            article.setLastModified(new Date());
            article.setAuthor(modelMapper.map(userService.getAuthUser(getIdToken()), UserEntity.class));
            this.newRepository.save(article);
            return modelMapper.map(article, NewDTO.class);
        }catch (Exception e){
            throw new UnsupportedOperationException("We couldn't create the article, for some reason.");
        }
    }

    private Long getIdToken() {  // TODO
        return 1L;
    }


    @Override
    public UserDTO getAuthUser(Long id){
        return this.userService.getAuthUser(id);
    }


    @Override
    public NewDTO findById(Long id) {
        Optional<NewEntity> n = this.newRepository.findById(id);
        if(n.isPresent()){
            NewEntity article = n.get();
            return modelMapper.map(article, NewDTO.class);
        }
        return new NewDTO();
    }

    @Override
    public NewDTO update(NewDTO newDTO, Long id) {
        Optional<NewEntity> n = this.newRepository.findById(id);

        if(n.isPresent()) {
            NewEntity article = n.get();
            article.setTitle(newDTO.getTitle());
            article.setText(newDTO.getText());
            article.setSubTitle(newDTO.getSubTitle());
            article.setLastModified(new Date());

            this.newRepository.save(article);
            return this.modelMapper.map(article, NewDTO.class);
        }
        throw new IllegalArgumentException("We not found the article to delete.");
    }

    @Override
    public String delete(Long id) {
        Optional<NewEntity> n = this.newRepository.findById(id);
        if(n.isPresent()){
            NewEntity newE = n.get();
            this.newRepository.delete(newE);
            return "Article delete with exit";
        }
        throw new IllegalArgumentException("The article isn't registered on the database.");
    }
}

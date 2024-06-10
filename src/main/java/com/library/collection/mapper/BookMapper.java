package com.library.collection.mapper;

import com.library.collection.entities.BookEntity;
import com.library.collection.models.dto.BookDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class BookMapper {

    @Autowired
    ModelMapper modelMapper;

    public List<BookDto> entityToDto(List<BookEntity> bookEntities){
        try{
            return modelMapper.map(bookEntities, new TypeToken<List<BookDto>>() {}.getType());
        }catch (Exception e){
            log.error("error while conversion : {}",e);
            return new ArrayList<>();
        }
    }


    public BookDto entityToDto(BookEntity bookEntity){
        try{
            return modelMapper.map(bookEntity, BookDto.class);
        }catch (Exception e){
            log.error("error while conversion : {}",e);
            return new BookDto();
        }
    }

    public List<BookEntity> dtoToEntity(List<BookDto> bookDtos){
        try{
            return modelMapper.map(bookDtos, new TypeToken<List<BookEntity>>() {}.getType());
        }catch (Exception e){
            log.error("error while conversion : {}",e);
            return new ArrayList<>();
        }
    }


    public BookEntity dtoToEntity(BookDto bookDto){
        try{
            return modelMapper.map(bookDto, BookEntity.class);
        }catch (Exception e){
            log.error("error while conversion : {}",e);
            return new BookEntity();
        }
    }
}

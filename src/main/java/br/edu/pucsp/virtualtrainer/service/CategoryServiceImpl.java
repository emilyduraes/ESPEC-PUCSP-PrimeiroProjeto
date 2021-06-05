package br.edu.pucsp.virtualtrainer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.mapper.CategoryMapper;
import br.edu.pucsp.virtualtrainer.mapper.FieldMapper;
import br.edu.pucsp.virtualtrainer.model.dto.CategoryDto;
import br.edu.pucsp.virtualtrainer.model.dto.FieldDto;
import br.edu.pucsp.virtualtrainer.model.entity.Category;
import br.edu.pucsp.virtualtrainer.repository.CategoryRepository;
import br.edu.pucsp.virtualtrainer.repository.FieldRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);
    private static final FieldMapper FIELD_MAPPER = Mappers.getMapper(FieldMapper.class);
    
    CategoryRepository repository;

    FieldRepository fieldRepository;

    public CategoryServiceImpl(CategoryRepository repository, FieldRepository fieldRepository){
        this.repository = repository;
        this.fieldRepository = fieldRepository;
    }

    @Override
    public CategoryDto findCategory(Long id) {
        Category category = repository.findById(id).orElseThrow(() -> new DataNotFoundException(id));
        return MAPPER.entityToDto(category);
    }

    @Override
    public List<CategoryDto> findAllCategories() {
        return repository.findAll()
        .stream()
        .map(MAPPER::entityToDto)
        .collect(Collectors.toList());
    }

    @Override
    public List<FieldDto> findFieldsByCategory(Long categoryId) {
        return fieldRepository.findByCategory(categoryId)
        .stream()
        .map(FIELD_MAPPER::entityToDto)
        .collect(Collectors.toList());
    }
    
}

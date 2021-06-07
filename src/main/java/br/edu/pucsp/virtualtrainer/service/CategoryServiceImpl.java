package br.edu.pucsp.virtualtrainer.service;

import br.edu.pucsp.virtualtrainer.domain.dto.CategoryDto;
import br.edu.pucsp.virtualtrainer.domain.dto.FieldDto;
import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import br.edu.pucsp.virtualtrainer.mapper.CategoryMapper;
import br.edu.pucsp.virtualtrainer.mapper.FieldMapper;
import br.edu.pucsp.virtualtrainer.repository.CategoryRepository;
import br.edu.pucsp.virtualtrainer.repository.FieldRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    @Cacheable(value = "categoryById", key = "#categoryId")
    public CategoryDto findCategory(Long categoryId) {
        return repository.findById(categoryId)
            .map(MAPPER::entityToDto)
            .orElseThrow(() -> new DataNotFoundException(categoryId));
}

    @Override
    @Cacheable("category")
    public List<CategoryDto> findAllCategories() {
        return repository.findAll()
            .stream()
            .map(MAPPER::entityToDto)
            .collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "fieldByCategory", key = "#categoryId")
    public List<FieldDto> findFieldsByCategory(Long categoryId) {
        return fieldRepository.findByCategory(categoryId)
            .stream()
            .map(FIELD_MAPPER::entityToDto)
            .collect(Collectors.toList());
    }
    
}

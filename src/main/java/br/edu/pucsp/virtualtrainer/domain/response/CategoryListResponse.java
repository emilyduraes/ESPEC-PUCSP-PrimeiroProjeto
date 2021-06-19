package br.edu.pucsp.virtualtrainer.domain.response;

import java.util.List;

import br.edu.pucsp.virtualtrainer.domain.dto.CategoryDto;

public class CategoryListResponse {
    private List<CategoryDto> categories;

    public CategoryListResponse(List<CategoryDto> categories){
        this.categories = categories;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }  
}

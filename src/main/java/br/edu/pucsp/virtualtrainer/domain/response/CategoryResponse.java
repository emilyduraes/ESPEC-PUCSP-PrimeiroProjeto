package br.edu.pucsp.virtualtrainer.domain.response;

import br.edu.pucsp.virtualtrainer.domain.dto.CategoryDto;

public class CategoryResponse {
    
    private CategoryDto category;

    public CategoryResponse(CategoryDto category){
        this.category = category;
    }
    
    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}

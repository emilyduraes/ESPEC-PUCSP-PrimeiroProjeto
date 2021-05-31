package br.edu.pucsp.virtualtrainer.transport.response;

import br.edu.pucsp.virtualtrainer.model.dto.CategoryDto;

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

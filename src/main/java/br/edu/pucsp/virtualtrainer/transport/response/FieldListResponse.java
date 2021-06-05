package br.edu.pucsp.virtualtrainer.transport.response;

import java.util.List;

import br.edu.pucsp.virtualtrainer.domain.dto.FieldDto;

public class FieldListResponse {
    
    private List<FieldDto> fields;

    public FieldListResponse(List<FieldDto> fields){
        this.setFields(fields);
    }

    public List<FieldDto> getFields() {
        return fields;
    }

    public void setFields(List<FieldDto> fields) {
        this.fields = fields;
    }
}

package br.edu.pucsp.virtualtrainer.domain.response;

import br.edu.pucsp.virtualtrainer.domain.entity.AuthUser;
import org.springframework.http.HttpStatus;

public class LoginResponse<T> {

    private HttpStatus responseCode;
    private MsgLoginResponse responseMessage;
    private T responseObject;

    public LoginResponse(HttpStatus responseCode, MsgLoginResponse responseMessage, T responseObject) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseObject = responseObject;
    }

    public LoginResponse(HttpStatus responseCode, MsgLoginResponse responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public HttpStatus getResponseCode() {
        return responseCode;
    }
    public void setResponseCode(HttpStatus responseCode) {
        this.responseCode = responseCode;
    }
    public MsgLoginResponse getResponseMessage() {
        return responseMessage;
    }
    public void setResponseMessage(MsgLoginResponse responseMessage) {
        this.responseMessage = responseMessage;
    }
    public T getResponseObject() {
        return responseObject;
    }
    public void setResponseObject(T responseObject) {
        this.responseObject = responseObject;
    }

    public void setSuccessResponse() {
        this.setResponseCode(HttpStatus.OK);
        this.setResponseMessage(MsgLoginResponse.OK);
    }

    public void setInternalServerErrorResponse() {
        this.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
        this.setResponseMessage(MsgLoginResponse.TRANSACTION_PROBLEM);
    }
}

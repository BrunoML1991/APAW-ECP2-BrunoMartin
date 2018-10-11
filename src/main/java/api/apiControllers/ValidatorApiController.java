package api.apiControllers;

import api.dtos.Dto;
import api.exceptions.ArgumentNotValidException;

public abstract class ValidatorApiController {

    protected void validateNotNull(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }

    protected abstract void validateDto(Dto dto);

}

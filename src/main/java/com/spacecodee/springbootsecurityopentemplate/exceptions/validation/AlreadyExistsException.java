package com.spacecodee.springbootsecurityopentemplate.exceptions.validation;

import com.spacecodee.springbootsecurityopentemplate.exceptions.base.BaseException;

public class AlreadyExistsException extends BaseException {
    public AlreadyExistsException(String messageKey, String locale) {
        super(messageKey, locale);
    }
}
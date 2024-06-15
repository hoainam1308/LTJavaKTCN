package com.example.tuan3.validator;

import com.example.tuan3.entity.PHONGBAN;
import com.example.tuan3.validator.annotation.ValidPhongBanId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPhongBanIdValidator implements ConstraintValidator<ValidPhongBanId, PHONGBAN> {
    @Override
    public boolean isValid(PHONGBAN phongban, ConstraintValidatorContext context){
        return phongban != null && phongban.getMa_Phong() != null;
    }
}

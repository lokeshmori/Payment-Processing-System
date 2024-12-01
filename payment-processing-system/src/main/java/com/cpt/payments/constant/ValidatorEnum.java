package com.cpt.payments.constant;

import java.util.HashMap;
import java.util.Map;

import com.cpt.payments.service.impl.validators.ValidatorRule1;
import com.cpt.payments.service.impl.validators.ValidatorRule2;
import com.cpt.payments.service.interfaces.Validator;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public enum ValidatorEnum {
	
	VALIDATOR_RULE1("VALIDATOR_RULE1", ValidatorRule1.class),
    VALIDATOR_RULE2("VALIDATOR_RULE2", ValidatorRule2.class);

    private static final Map<String, ValidatorEnum> NAME_TO_ENUM_MAP = new HashMap<>();

    static {
        // Populate the map for quick lookup
        for (ValidatorEnum validator : values()) {
            NAME_TO_ENUM_MAP.put(validator.name, validator);
        }
    }

    private final String name;
    private final Class<? extends Validator> validatorClass;

    ValidatorEnum(String name, Class<? extends Validator> validatorClass) {
        this.name = name;
        this.validatorClass = validatorClass;
    }

    public Class<? extends Validator> getValidatorClass() {
        return validatorClass;
    }

    public static Class<? extends Validator> getClassByName(String name) {
        ValidatorEnum validatorEnum = NAME_TO_ENUM_MAP.get(name);
        if (validatorEnum == null) {
              
        	log.error("Validor is not found for rule : {}", name);
        	  return null ;
        }
        return validatorEnum.getValidatorClass();
    }

}

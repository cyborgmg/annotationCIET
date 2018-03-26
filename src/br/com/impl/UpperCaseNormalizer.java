package br.com.impl;

import java.lang.annotation.Annotation;

import br.com.interfaces.UpperCase;

public class UpperCaseNormalizer extends DataNormalizerAbstract {

    @Override
    protected Object execute(Object value, Annotation annotation) {
        if (value != null && value instanceof String) {
            return ((String) value).toUpperCase();
        }
        return value;
    }

    @Override
    protected Class<? extends Annotation>[] supportedTypes() {
        return new Class[]{UpperCase.class};
    }

}
package br.com.impl;

import java.lang.annotation.Annotation;

import org.apache.commons.lang.StringUtils;

import br.com.interfaces.Truncate;

public class TruncateNormalizer extends DataNormalizerAbstract {

    @Override
    protected Object execute(Object value, Annotation annotation) {
        Truncate truncate = (Truncate) annotation;
        if (value != null && value instanceof String) {
            return StringUtils.substring( (String) value, 0, truncate.at());
        }
        return value;
    }

    @Override
    protected Class<? extends Annotation>[] supportedTypes() {
        return new Class[]{Truncate.class};
    }
}
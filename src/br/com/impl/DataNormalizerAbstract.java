package br.com.impl;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

import br.com.interfaces.DataNormalizer;

public abstract class DataNormalizerAbstract implements DataNormalizer{

    @Override
    public boolean isSupported(Annotation annotation) {
        return annotation != null
                && supportedTypes() != null
                && Stream.of(supportedTypes())
                    .anyMatch(classes ->
                            classes.getClass()
                                    .isAssignableFrom(annotation.getClass()));
    }

    @Override
    public Object normalize(Object value, Annotation annotation) {
        if (!isSupported(annotation)) {
            throw new IllegalStateException();
        }
        return execute(value, annotation);
    }

    protected abstract Object execute(Object value, Annotation annotation);

    protected abstract Class<? extends Annotation>[] supportedTypes();
}
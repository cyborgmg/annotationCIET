package br.com.interfaces;

import java.lang.annotation.Annotation;

public interface DataNormalizer {

    boolean isSupported(Annotation annotation);

    Object normalize(Object value, Annotation annotation);

}
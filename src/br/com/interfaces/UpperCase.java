package br.com.interfaces;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.impl.UpperCaseNormalizer;

@Documented
@Target({ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Normalizer(normalizedBy=UpperCaseNormalizer.class)
public @interface UpperCase {

}
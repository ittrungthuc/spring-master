package com.trungthuc.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ProcedureEx {
    String value() default "";//database procedure name short for procedureName()
    String procedureName() default ""; //database procedure name
    String name() default "";//name of the JPA @NamedStoredProcedureQuery
    String outputParameterName() default "";//output parameter name
}

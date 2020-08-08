package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * the methods of annotations
 * - cannot have bodies
 * - cannot provide throws clause
 * - return type must be primitive, String Class, enum or annotation or array of these types
 *
 * This annotation can only be applied to methods (ElementType.METHOD)
 */
@Target({ElementType.METHOD})
public @interface ToDo {

    int id();
    String finishDate();

    // n/a is default return type.
    String coder() default "n/a";
}

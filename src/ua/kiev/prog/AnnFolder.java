package ua.kiev.prog;
import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AnnFolder {
    public String paramFolder() default "D:\\Test1";
    public String methodName() ;

}

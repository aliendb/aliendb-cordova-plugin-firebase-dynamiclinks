package aliendb.cordova.firebase;

import ReflectiveCordovaPlugin.ExecutionThread;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CordovaMethod {
    public ExecutionThread value() default ExecutionThread.MAIN;
    public String action() default "";
}

package com.example.anno;

import com.example.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {StateValidation.class})  // 提供校验规则的类
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface State {
    // 提供检验失败后的提示信息
    String message() default "{state参数的值只能是已发布和草稿}";

    // 指定组
    Class<?>[] groups() default {};

    // 负载 获取state注解的负载信息
    Class<? extends Payload>[] payload() default {};
}

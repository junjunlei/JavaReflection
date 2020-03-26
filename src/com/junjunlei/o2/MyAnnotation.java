package com.junjunlei.o2;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 *  * 3. 如何自定义注解：参照@SuppressWarnings定义
 *       * ① 注解声明为：@interface
 *       * ② 内部定义成员，通常使用value表示
 *       * ③ 可以指定成员的默认值，使用default定义
 *       * ④ 如果自定义注解没有成员，表明是一个标识作用。
 *
 *      如果注解有成员，在使用注解时，需要指明成员的值。
 *      自定义注解必须配上注解的信息处理流程(使用反射)才有意义。
 *      自定义注解通过都会指明两个元注解：Retention、Target
 *
 *      4. jdk 提供的4种元注解
 *        元注解：对现有的注解进行解释说明的注解
 *      Retention：指定所修饰的 Annotation 的生命周期：SOURCE\CLASS（默认行为）\RUNTIME
 *             只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 *      Target:用于指定被修饰的 Annotation 能用于修饰哪些程序元素
 *      *******出现的频率较低*******
 *      Documented:表示所修饰的注解在被javadoc解析时，保留下来。
 *      Inherited:被它修饰的 Annotation 将具有继承性。
 *
 *      5.通过反射获取注解信息 ---到反射内容时系统讲解
 *
 *      6. jdk 8 中注解的新特性：可重复注解、类型注解
 *
 *      6.1 可重复注解：① 在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 *                     ② MyAnnotation的Target和Retention等元注解与MyAnnotations相同。
 *
 *      6.2 类型注解：
 *      ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 *      ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 * @author leijunjun18@163.com
 * @create 2020-03-02 22:23
 */
//@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {
     String value() default "hello";
}

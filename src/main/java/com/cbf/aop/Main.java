package com.cbf.aop;

import com.cbf.aop.arg_annotation_example.ArgAnnotationUse;
import com.cbf.aop.arg_annotation_example.ArgExampleAnnotatedByArgFlyAnnotation;
import com.cbf.aop.excecution.AopConfig;
import com.cbf.aop.target_annotation_example.TargetAnnotationExample;
import com.cbf.aop.target_example.TargetExampleImpl;
import com.cbf.aop.target_example.TargetExampleInterface;
import com.cbf.aop.this_example.ThisExampleInterface;
import com.cbf.aop.within_annotation_example.WithinAnnotationExample;
import com.cbf.aop.within_example.WithinExampleInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author yingge
 * @Date 2022/9/6 17:52
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
//        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
//        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
//        demoAnnotationService.add();
//        demoMethodService.add();
//        ArgUse argUse = context.getBean(ArgUse.class);
//        argUse.useArgFly(new ArgExampleConcrete1());
//        ArgAnnotationUse argAnnotationUse = context.getBean(ArgAnnotationUse.class);
//        argAnnotationUse.useArgAnnotation(new ArgExampleAnnotatedByArgFlyAnnotation());
//        TargetExampleInterface targetExampleInterface = context.getBean(TargetExampleInterface.class);
//        targetExampleInterface.test1();
//        targetExampleInterface.test2();
//        ThisExampleInterface thisExampleInterface = context.getBean(ThisExampleInterface.class);
//        thisExampleInterface.test1();
//        thisExampleInterface.test2();
//        WithinExampleInterface withinExampleInterface = context.getBean(WithinExampleInterface.class);
//        withinExampleInterface.test1();
////        withinExampleInterface.test2();
//        TargetAnnotationExample targetAnnotationExample = context.getBean(TargetAnnotationExample.class);
//        targetAnnotationExample.test1();
//        targetAnnotationExample.test2();
        WithinAnnotationExample withinAnnotationExample = context.getBean(WithinAnnotationExample.class);
        withinAnnotationExample.test1();
        withinAnnotationExample.test2();
        context.close();
    }

}

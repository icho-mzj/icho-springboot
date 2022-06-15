package com.icho.springsource.importTest.importSelectTest;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: icho
 * @Date: 2022/6/14 20:02
 * @Describe:
 */
public class ImportSelectTest implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.icho.springboot.importTest.compent.Car"};
    }
}

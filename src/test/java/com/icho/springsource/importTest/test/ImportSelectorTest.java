package com.icho.springsource.importTest.test;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: icho
 * @Date: 2022/6/15 14:57
 * @Describe:
 */
public class ImportSelectorTest implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.icho.springsource.importTest.test.Human"};
    }
}

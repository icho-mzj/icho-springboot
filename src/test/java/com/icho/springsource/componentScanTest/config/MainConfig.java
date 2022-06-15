package com.icho.springsource.componentScanTest.config;

import com.icho.springsource.componentScanTest.TypeFilterTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @Author: icho
 * @Date: 2022/6/14 18:49
 * @Describe:
 */
/*@ComponentScan(value = {"com.icho.springboot.componentScanTest"}, excludeFilters = {
        //@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class})
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = {ServiceTest.class})
})*/
@ComponentScan(value = {"com.icho.springsource.componentScanTest"}, includeFilters = {
        //@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class})
        @ComponentScan.Filter(type = FilterType.CUSTOM,value = {TypeFilterTest.class})
}, useDefaultFilters = false)
public class MainConfig {
}

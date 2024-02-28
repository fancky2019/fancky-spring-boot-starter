package com.example.fanckyspringbootstarter.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class FanckyConfigurationSelector  implements DeferredImportSelector {
    public FanckyConfigurationSelector() {
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{FanckyAutoConfiguration.class.getName()};
    }
}

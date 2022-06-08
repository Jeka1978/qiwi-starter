package com.qiwi.qiwistarter;

import com.qiwi.ironbank.legacy.Legacy;
import com.qiwi.ironbank.legacy.Singleton;
import org.reflections.Reflections;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.beans.Introspector;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class LegacyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private Environment environment;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        String packagesToScanForLegacyBeans = environment.getProperty("qiwi.legacy.packages");
        if (packagesToScanForLegacyBeans == null) {
            packagesToScanForLegacyBeans = "com.qiwi.ironbank.legacy";
        }
        Reflections scanner = new Reflections(packagesToScanForLegacyBeans);
        Set<Class<?>> classes = scanner.getTypesAnnotatedWith(Singleton.class);
        for (Class<?> aClass : classes) {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(aClass);
            beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
            beanDefinition.addQualifier(new AutowireCandidateQualifier(Legacy.class));
            registry.registerBeanDefinition(Introspector.decapitalize(aClass.getSimpleName()),beanDefinition);
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}






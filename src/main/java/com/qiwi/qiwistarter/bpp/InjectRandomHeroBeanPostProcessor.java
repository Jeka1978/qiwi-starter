package com.qiwi.qiwistarter.bpp;

import com.qiwi.qiwistarter.annotations.InjectRandomHero;
import com.qiwi.qiwistarter.model.Hero;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class InjectRandomHeroBeanPostProcessor implements BeanPostProcessor {
    private Random random = new Random();
    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomHero.class)) {
                Hero hero = new Hero();
                hero.setName("John Snow");
                hero.setAge(random.nextInt(100));
                field.setAccessible(true);
                field.set(bean,hero);
            }
        }
        return bean;
    }
}

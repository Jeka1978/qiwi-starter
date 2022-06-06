package com.qiwi.qiwistarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.sql.DataSource;
import javax.swing.*;

/**
 * @author Evgeny Borisov
 */
public class OnProductionCondition implements Condition {

    private static Boolean answer;


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if (answer == null) {
            answer = JOptionPane.showInputDialog("is it production?").toLowerCase().equals("true");
        }
        return answer;
    }
}

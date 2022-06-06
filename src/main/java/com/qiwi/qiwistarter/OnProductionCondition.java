package com.qiwi.qiwistarter;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.swing.*;
import java.util.Locale;

/**
 * @author Evgeny Borisov
 */
public class OnProductionCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String answer = JOptionPane.showInputDialog("is it production?").toLowerCase();
        return answer.contains("true");
    }
}

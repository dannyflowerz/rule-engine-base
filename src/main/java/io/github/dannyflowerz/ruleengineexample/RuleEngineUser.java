package io.github.dannyflowerz.ruleengineexample;

import org.springframework.beans.factory.annotation.Autowired;

public class RuleEngineUser {

    @Autowired
    private DecisionRuleEngine decisionRuleEngine;

    public void decide() {
        Decision decision = decisionRuleEngine.evaluate(digitizedCard);
    }

}

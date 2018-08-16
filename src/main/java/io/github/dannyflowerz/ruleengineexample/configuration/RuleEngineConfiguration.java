package io.github.dannyflowerz.ruleengineexample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.dannyflowerz.ruleengineexample.DecisionRuleEngine;

@Configuration
public class RuleEngineConfiguration {

    /**
     * create a Decision rule engine
     * @return a DecisionRuleEngine
     */
    @Bean
    public DecisionRuleEngine decisionRuleEngine() {
        DecisionRuleEngine ret = new DecisionRuleEngine(new PropertyFileJNDIUtilImpl());
        ret.init();
        return ret;
    }

}

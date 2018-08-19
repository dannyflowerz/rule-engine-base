package io.github.dannyflowerz.ruleenginebase.engine;

import io.github.dannyflowerz.ruleenginebase.RuleException;
import io.github.dannyflowerz.ruleenginebase.rule.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Base class representing an exclusive rule engine
 * Only one of the multiple provided rules should apply
 *
 * @param <I> input type
 * @param <O> output type representing the decision
 */
public abstract class ExclusiveRuleEngine<I, O> extends Rule<I, O> {

    protected List<Rule<I, O>> rules;

    protected ExclusiveRuleEngine(boolean enabled) {
        super(enabled);
        rules = new ArrayList<>();
    }

    @Override
    protected O doEvaluate(I input) {
        List<O> evaluatedRules = rules.stream()
                .map(rule -> rule.evaluate(input))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        if (evaluatedRules.size() != 1) {
            throw new RuleException("Multiple rules applied for input " + input + ", while only one should be effective");
        } else {
            return evaluatedRules.get(0);
        }
    }

    @Override
    protected boolean isApplicable(I input) {
        return true;
    }

}


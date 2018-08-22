package io.github.dannyflowerz.ruleenginebase.engine;

import io.github.dannyflowerz.ruleenginebase.RuleException;

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
public abstract class ExclusiveRuleEngine<I, O> extends RuleEngine<I, O> {

    protected ExclusiveRuleEngine(boolean enabled) {
        super(enabled);
    }

    @Override
    protected O doEvaluate(I input) {
        List<O> evaluatedRules = getRules().stream()
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


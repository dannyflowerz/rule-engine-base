package io.github.dannyflowerz.ruleengineexample.engine;

import io.github.dannyflowerz.ruleengineexample.rule.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Base class representing a decision aggregating rule engine
 * Several of the provided rules may apply that get aggregated into a final decision
 *
 * @param <I> input type
 * @param <O> output type representing the decision
 */
public abstract class AggregatingRuleEngine<I, O> extends Rule<I, O> {

    protected List<Rule<I, O>> rules;

    protected AggregatingRuleEngine(boolean enabled) {
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
        return aggregate(evaluatedRules);
    }

    @Override
    protected boolean isApplicable(I input) {
        return true;
    }

    protected abstract O aggregate(List<O> decisions);

}


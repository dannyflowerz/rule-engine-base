package io.github.dannyflowerz.ruleenginebase.engine;

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
public abstract class AggregatingRuleEngine<I, O> extends RuleEngine<I, O> {

    protected AggregatingRuleEngine(boolean enabled) {
        super(enabled);
    }

    @Override
    protected O doEvaluate(I input) {
        List<O> evaluatedRules = getRules().stream()
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

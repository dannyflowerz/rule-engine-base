package io.github.dannyflowerz.ruleenginebase.rule;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * Base class representing a rule
 * A rule evaluates an input and creates a decision as the output
 *
 * @param <I> input type
 * @param <O> output type representing the decision
 */
@Slf4j
public abstract class Rule<I, O> {

    @Getter
    private boolean enabled;

    protected Rule(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Evaluates this rule against the provided input
     *
     * @param input the input to be evaluated aganist this rule
     * @return an optional decision that will be empty if the rule is not applicable
     */
    public Optional<O> evaluate(I input) {
        if (this.enabled && this.isApplicable(input)) {
            log.debug("Evaluating rule: " + this.getClass().getSimpleName() + " for input: " + input.toString());
            return Optional.of(this.doEvaluate(input));
        } else {
            return Optional.empty();
        }
    }

    protected abstract O doEvaluate(I input);

    protected abstract boolean isApplicable(I input);

}
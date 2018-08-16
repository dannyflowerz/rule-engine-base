package io.github.dannyflowerz.ruleengineexample;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import nl.ing.riaf.core.util.JNDIUtil;

public abstract class ExclusiveRuleEngine<INPUT_TYPE, OUTPUT_TYPE> extends Rule<INPUT_TYPE, OUTPUT_TYPE> {
    public ExclusiveRuleEngine(JNDIUtil util) {
        super(util);
    }

    protected abstract List<Rule<INPUT_TYPE, OUTPUT_TYPE>> getRules();

    protected OUTPUT_TYPE doEvaluate(INPUT_TYPE input) {
        List<OUTPUT_TYPE> ret = (List)this.getRules().stream().filter((rule) -> {
            return rule.isApplicable(input);
        }).map((rule) -> {
            return rule.evaluate(input);
        }).collect(Collectors.toList());
        if (ret.size() != 1) {
            throw new RuleException("Rule Engine evaluated to multiple rule, while only one should be effective.");
        } else {
            return ret.iterator().next();
        }
    }
}


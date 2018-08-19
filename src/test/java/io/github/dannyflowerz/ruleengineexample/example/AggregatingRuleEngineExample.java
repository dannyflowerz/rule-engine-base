package io.github.dannyflowerz.ruleengineexample.example;

import io.github.dannyflowerz.ruleengineexample.engine.AggregatingRuleEngine;

import java.util.List;
import java.util.stream.Collectors;

public class AggregatingRuleEngineExample extends AggregatingRuleEngine<Input, Decision> {

    public AggregatingRuleEngineExample(boolean enabled) {
        super(enabled);
        rules.add(new FooIsGoodRule(true));
        rules.add(new BarIsNotGoodRule(true));
        rules.add(new BarIsBadRule(true));
    }

    @Override
    protected Decision aggregate(List<Decision> decisions) {
        String allReasons = decisions.stream()
                .filter(decision -> !decision.isAccepted())
                .map(Decision::getRejectionReason).collect(Collectors.joining(", "));
        return allReasons.isEmpty() ? Decision.builder().accepted(true).build() :
                Decision.builder().accepted(false).rejectionReason(allReasons).build();
    }

}

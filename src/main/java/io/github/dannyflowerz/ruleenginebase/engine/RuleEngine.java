package io.github.dannyflowerz.ruleenginebase.engine;

import io.github.dannyflowerz.ruleenginebase.rule.Rule;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

abstract class RuleEngine<I, O> extends Rule<I, O> {

    @Getter
    private List<Rule<I, O>> rules = new ArrayList<>();

    RuleEngine(boolean enabled) {
        super(enabled);
    }

}

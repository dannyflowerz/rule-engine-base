package io.github.dannyflowerz.ruleenginebase.example;

import io.github.dannyflowerz.ruleenginebase.rule.Rule;

public class FooIsGoodRule extends Rule<Input, Decision> {

	FooIsGoodRule(boolean enabled) {
		super(enabled);
	}

	@Override
	protected Decision doEvaluate(Input input) {
        return Decision.builder().accepted(true).build();
	}

	@Override
	protected boolean isApplicable(Input input) {
		return Input.Discriminator.FOO.equals(input.discriminator);
	}

}
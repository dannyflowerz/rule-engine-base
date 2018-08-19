package io.github.dannyflowerz.ruleengineexample.example;

import io.github.dannyflowerz.ruleengineexample.rule.Rule;

public class BarIsNotGoodRule extends Rule<Input, Decision> {

	BarIsNotGoodRule(boolean enabled) {
		super(enabled);
	}

	@Override
	protected Decision doEvaluate(Input input) {
		return Decision.builder().accepted(false).rejectionReason("Bar is not good").build();
	}

	@Override
	protected boolean isApplicable(Input input) {
		return Input.Discriminator.BAR.equals(input.discriminator);
	}

}
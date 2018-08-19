package io.github.dannyflowerz.ruleengineexample.example;

import io.github.dannyflowerz.ruleengineexample.rule.Rule;

public class BarIsBadRule extends Rule<Input, Decision> {

	BarIsBadRule(boolean enabled) {
		super(enabled);
	}

	@Override
	protected Decision doEvaluate(Input input) {
		return Decision.builder().accepted(false).rejectionReason("Bar is bad").build();
	}

	@Override
	protected boolean isApplicable(Input input) {
		return Input.Discriminator.BAR.equals(input.discriminator);
	}

}
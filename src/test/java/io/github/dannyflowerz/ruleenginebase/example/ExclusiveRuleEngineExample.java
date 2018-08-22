package io.github.dannyflowerz.ruleenginebase.example;

import io.github.dannyflowerz.ruleenginebase.engine.ExclusiveRuleEngine;

public class ExclusiveRuleEngineExample extends ExclusiveRuleEngine<Input, Decision> {
	
	public ExclusiveRuleEngineExample(boolean enabled, boolean createMessedUpInstance) {
		super(enabled);
		getRules().add(new FooIsGoodRule(true));
		getRules().add(new BarIsNotGoodRule(true));
		if (createMessedUpInstance) {
            getRules().add(new BarIsBadRule(true));
        }
	}

}

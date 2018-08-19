package io.github.dannyflowerz.ruleenginebase.example;

import io.github.dannyflowerz.ruleenginebase.engine.ExclusiveRuleEngine;

public class ExclusiveRuleEngineExample extends ExclusiveRuleEngine<Input, Decision> {
	
	public ExclusiveRuleEngineExample(boolean enabled, boolean createMessedUpInstance) {
		super(enabled);
		rules.add(new FooIsGoodRule(true));
		rules.add(new BarIsNotGoodRule(true));
		if (createMessedUpInstance) {
            rules.add(new BarIsBadRule(true));
        }
	}

}

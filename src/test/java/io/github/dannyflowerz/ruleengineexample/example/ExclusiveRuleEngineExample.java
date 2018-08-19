package io.github.dannyflowerz.ruleengineexample.example;

import io.github.dannyflowerz.ruleengineexample.engine.ExclusiveRuleEngine;

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

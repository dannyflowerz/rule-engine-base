package io.github.dannyflowerz.ruleengineexample;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import nl.ing.riaf.core.util.JNDIUtil;
import nl.ing.sc.model.digitizedCard.DigitizedCard;
import nl.ing.sol.rules.ExclusiveRuleEngine;
import nl.ing.sol.rules.Rule;

/**
 * meta rule: runs all other rules exclusively: if more than one rule are candidates, an error is generated
 * 
 * @author lg49im
 *
 */
public class DecisionRuleEngine extends ExclusiveRuleEngine<DigitizedCard, Decision> {
	
	public DecisionRuleEngine(JNDIUtil util) {
		super(util);
	}

	@Getter(value= AccessLevel.PROTECTED)
	List<Rule<DigitizedCard, Decision>> rules = new ArrayList<>();

	@Override
	public void init() {
		rules.add(new GreenAdviceRule(getJndiUtil()));
		rules.add(new OrangeAdviceRule(getJndiUtil()));
		rules.add(new YellowAdviceForInAppCardRule(getJndiUtil()));
		rules.add(new YellowAdviceForManualCardRule(getJndiUtil()));
		rules.add(new YellowAdviceForOnFileCardRule(getJndiUtil()));
		rules.add(new RedAdviceRule(getJndiUtil()));
		
		rules.forEach(rule -> {
			rule.load();
			rule.init();
		});
	}

	@Override
	public boolean isApplicable(final DigitizedCard input) {
		return true;
	}

}

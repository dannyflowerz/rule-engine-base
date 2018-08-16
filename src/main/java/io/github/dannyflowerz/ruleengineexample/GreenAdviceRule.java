package io.github.dannyflowerz.ruleengineexample;

import nl.ing.riaf.core.util.JNDIUtil;
import nl.ing.sc.model.digitizedCard.DigitizedCard;
import nl.ing.sc.model.digitizedCard.TokenizationRecommendation;
import nl.ing.sol.rules.Rule;

/**
 * 
 * @author lg49im
 *
 */
public class GreenAdviceRule extends Rule<DigitizedCard, Decision> {

	GreenAdviceRule(JNDIUtil util) {
		super(util);
	}

	@Override
	public void init() {
	}

	@Override
	public boolean isApplicable(DigitizedCard input) {
        return input.getTokenizationRecommendation() == null ||
                input.getTokenizationRecommendation().getWallet() == null ||
                input.getTokenizationRecommendation().getWallet().getRecommendedActivation() == null ||
                TokenizationRecommendation.WalletRecommendation.WalletRecommendationType.Approve
                        .equals(input.getTokenizationRecommendation().getWallet().getRecommendedActivation());
    }

	@Override
	public Decision doEvaluate(DigitizedCard input) {
		return Decision.builder().finalDecision(DigitizedCard.DecisionType.Approved).build();
	}

}
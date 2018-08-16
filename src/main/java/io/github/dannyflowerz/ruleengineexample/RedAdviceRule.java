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
public class RedAdviceRule extends Rule<DigitizedCard, Decision> {

	RedAdviceRule(JNDIUtil util) {
		super(util);
	}

	@Override
	public void init() {
	}

    @Override
    public Decision doEvaluate(DigitizedCard input) {
        return Decision.builder().finalDecision(DigitizedCard.DecisionType.Declined).build();
    }

	@Override
	public boolean isApplicable(DigitizedCard input) {
        return input.getTokenizationRecommendation() != null &&
                input.getTokenizationRecommendation().getWallet() != null &&
                TokenizationRecommendation.WalletRecommendation.WalletRecommendationType.Reject
                        .equals(input.getTokenizationRecommendation().getWallet().getRecommendedActivation());
	}

}
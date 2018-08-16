package io.github.dannyflowerz.ruleengineexample;

import nl.ing.riaf.core.util.JNDIUtil;
import nl.ing.sc.model.digitizedCard.DigitizedCard;
import nl.ing.sc.model.digitizedCard.DigitizedCard.PansourceType;
import nl.ing.sc.model.digitizedCard.TokenizationRecommendation;
import nl.ing.sol.rules.Rule;

/**
 * 
 * @author lg49im
 *
 */
public class YellowAdviceForInAppCardRule extends Rule<DigitizedCard, Decision> {

	YellowAdviceForInAppCardRule(JNDIUtil util) {
		super(util);
	}

	@Override
	public void init() {
	}

	@Override
	public Decision doEvaluate(DigitizedCard input) {
		return Decision.builder().finalDecision(DigitizedCard.DecisionType.Approved).build();
	}

	@Override
	public boolean isApplicable(DigitizedCard input) {
		return input.getTokenizationRecommendation() != null &&
				input.getTokenizationRecommendation().getWallet() != null &&
                TokenizationRecommendation.WalletRecommendation.WalletRecommendationType.ApproveWithIdnv
                        .equals(input.getTokenizationRecommendation().getWallet().getRecommendedActivation()) &&
                PansourceType.CardAddedViaApp.equals(input.getPanSource());
	}

}

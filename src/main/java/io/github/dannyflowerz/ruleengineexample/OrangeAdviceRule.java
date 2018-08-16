package io.github.dannyflowerz.ruleengineexample;

import java.util.Collections;

import nl.ing.riaf.core.util.JNDIUtil;
import nl.ing.sc.model.digitizedCard.DigitizedCard;
import nl.ing.sc.model.digitizedCard.TokenizationRecommendation;
import nl.ing.sc.model.digitizedCard.activation.ActivationMethod;
import nl.ing.sol.rules.Rule;

/**
 * 
 * @author lg49im
 *
 */
public class OrangeAdviceRule extends Rule<DigitizedCard, Decision> {

	OrangeAdviceRule(JNDIUtil util) {
		super(util);
	}

	@Override
	public void init() {
	}

	@Override
	public Decision doEvaluate(DigitizedCard input) {
		return Decision.builder()
			  .finalDecision(DigitizedCard.DecisionType.ApprovedRequiresActivation)
			  .methods(Collections.singletonList(ActivationMethod.MethodType.Sms)).build();
	}

	@Override
	public boolean isApplicable(DigitizedCard input) {
		return input.getTokenizationRecommendation() != null &&
				input.getTokenizationRecommendation().getWallet() != null &&
                TokenizationRecommendation.WalletRecommendation.WalletRecommendationType.ApproveWithStrongIdnv
                        .equals(input.getTokenizationRecommendation().getWallet().getRecommendedActivation());
	}

}

package io.github.dannyflowerz.ruleengineexample;

import java.util.Arrays;

import nl.ing.riaf.core.util.JNDIUtil;
import nl.ing.sc.model.digitizedCard.DigitizedCard;
import nl.ing.sc.model.digitizedCard.DigitizedCard.PansourceType;
import nl.ing.sc.model.digitizedCard.TokenizationRecommendation;
import nl.ing.sc.model.digitizedCard.activation.ActivationMethod;
import nl.ing.sol.rules.Rule;

/**
 * 
 * @author lg49im
 *
 */
public class YellowAdviceForManualCardRule extends Rule<DigitizedCard, Decision> {

	YellowAdviceForManualCardRule(JNDIUtil util) {
		super(util);
	}

	@Override
	public void init() {
	}

	@Override
	public Decision doEvaluate(DigitizedCard input) {
        return Decision.builder()
                .finalDecision(DigitizedCard.DecisionType.ApprovedRequiresActivation)
                .methods(Arrays.asList(ActivationMethod.MethodType.Sms, ActivationMethod.MethodType.Bap)).build();
	}

	@Override
	public boolean isApplicable(DigitizedCard input) {
		return input.getTokenizationRecommendation() != null &&
				input.getTokenizationRecommendation().getWallet() != null &&
				TokenizationRecommendation.WalletRecommendation.WalletRecommendationType.ApproveWithIdnv
						.equals(input.getTokenizationRecommendation().getWallet().getRecommendedActivation()) &&
				PansourceType.CardAddedManually.equals(input.getPanSource());
	}

}

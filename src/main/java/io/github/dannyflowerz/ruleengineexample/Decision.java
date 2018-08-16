package io.github.dannyflowerz.ruleengineexample;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import nl.ing.sc.model.digitizedCard.DigitizedCard;
import nl.ing.sc.model.digitizedCard.activation.ActivationMethod;

/**
 * Represents a final decision to be returned in a TAR response
 * @author lg49im
 *
 */
@Getter
@Builder
public class Decision {

	private DigitizedCard.DecisionType finalDecision;

	@Builder.Default
	private List<ActivationMethod.MethodType> methods = new ArrayList<>();
}

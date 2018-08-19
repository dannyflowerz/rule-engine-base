package io.github.dannyflowerz.ruleenginebase.example;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Decision {

	private boolean accepted;
	private String rejectionReason;

}

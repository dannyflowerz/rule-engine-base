package io.github.dannyflowerz.ruleengineexample.example;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Decision {

	private boolean accepted;
	private String rejectionReason;

}

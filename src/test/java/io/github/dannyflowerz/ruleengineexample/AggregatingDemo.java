package io.github.dannyflowerz.ruleengineexample;

import io.github.dannyflowerz.ruleengineexample.example.AggregatingRuleEngineExample;
import io.github.dannyflowerz.ruleengineexample.example.Decision;
import io.github.dannyflowerz.ruleengineexample.example.Input;
import org.junit.Test;

import static org.junit.Assert.*;

public class AggregatingDemo {

    private AggregatingRuleEngineExample aggregating = new AggregatingRuleEngineExample(true);

    @Test
    public void should_decide_accepted_for_FOO() {
        assertTrue(aggregating.evaluate(new Input(Input.Discriminator.FOO)).get().isAccepted());
    }

    @Test
    public void should_decide_not_accepted_for_BAR_with_concatenated_reason() {
        Decision decision = aggregating.evaluate(new Input(Input.Discriminator.BAR)).get();

        assertFalse(decision.isAccepted());
        assertEquals("Bar is not good, Bar is bad", decision.getRejectionReason());
    }

}

package io.github.dannyflowerz.ruleenginebase;

import io.github.dannyflowerz.ruleenginebase.example.AggregatingRuleEngineExample;
import io.github.dannyflowerz.ruleenginebase.example.Decision;
import io.github.dannyflowerz.ruleenginebase.example.Input;
import org.junit.Test;

import static org.junit.Assert.*;

public class AggregatingDemoTest {

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

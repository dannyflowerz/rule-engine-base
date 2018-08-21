package io.github.dannyflowerz.ruleenginebase;

import io.github.dannyflowerz.ruleenginebase.example.AggregatingRuleEngineExample;
import io.github.dannyflowerz.ruleenginebase.example.Decision;
import io.github.dannyflowerz.ruleenginebase.example.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AggregatingDemoTest {

    private AggregatingRuleEngineExample aggregating = new AggregatingRuleEngineExample(true);

    @Test
    @DisplayName("Should decide accepted for FOO")
    void evaluateFoo() {
        assertTrue(aggregating.evaluate(new Input(Input.Discriminator.FOO)).get().isAccepted());
    }

    @Test
    @DisplayName("Should decide not accepted for BAR with concatenated reason")
    void evaluateBar() {
        Decision decision = aggregating.evaluate(new Input(Input.Discriminator.BAR)).get();

        assertFalse(decision.isAccepted());
        assertEquals("Bar is not good, Bar is bad", decision.getRejectionReason());
    }

}

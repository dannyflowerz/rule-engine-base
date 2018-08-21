package io.github.dannyflowerz.ruleenginebase;

import io.github.dannyflowerz.ruleenginebase.example.ExclusiveRuleEngineExample;
import io.github.dannyflowerz.ruleenginebase.example.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExclusiveDemoTest {

    private ExclusiveRuleEngineExample exclusive = new ExclusiveRuleEngineExample(true, false);
    private ExclusiveRuleEngineExample exclusiveMessedUp = new ExclusiveRuleEngineExample(true, true);

    @Test
    @DisplayName("Should decide accepted for FOO")
    void evaluateFoo() {
        assertTrue(exclusive.evaluate(new Input(Input.Discriminator.FOO)).get().isAccepted());
    }

    @Test
    @DisplayName("Should decide not accepted fo BAR")
    void evaluateBar() {
        assertFalse(exclusive.evaluate(new Input(Input.Discriminator.BAR)).get().isAccepted());
    }

    @Test
    @DisplayName("Should throw RuleException if more than one rule applies")
    void wrongSetUp() {
        RuleException exception = assertThrows(RuleException.class, () -> exclusiveMessedUp.evaluate(new Input(Input.Discriminator.BAR)));
        assertTrue(exception.getMessage().startsWith("Multiple rules applied for input"));
    }

}

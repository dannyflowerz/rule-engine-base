package io.github.dannyflowerz.ruleengineexample;

import io.github.dannyflowerz.ruleengineexample.example.ExclusiveRuleEngineExample;
import io.github.dannyflowerz.ruleengineexample.example.Input;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExclusiveDemo {

    private ExclusiveRuleEngineExample exclusive = new ExclusiveRuleEngineExample(true, false);
    private ExclusiveRuleEngineExample exclusiveMessedUp = new ExclusiveRuleEngineExample(true, true);

    @Test
    public void should_decide_accepted_for_FOO() {
        assertTrue(exclusive.evaluate(new Input(Input.Discriminator.FOO)).get().isAccepted());
    }

    @Test
    public void should_decide_not_accepted_for_BAR() {
        assertFalse(exclusive.evaluate(new Input(Input.Discriminator.BAR)).get().isAccepted());
    }

    @Test(expected = RuleException.class)
    public void should_throw_RuleException_if_more_than_one_rule_applies() {
        exclusiveMessedUp.evaluate(new Input(Input.Discriminator.BAR));
    }

}

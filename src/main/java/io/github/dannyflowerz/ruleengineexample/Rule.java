package io.github.dannyflowerz.ruleengineexample;

import nl.ing.riaf.core.util.JNDIUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Rule<INPUT_TYPE, OUTPUT_TYPE> {
    private static final Logger log = LoggerFactory.getLogger(Rule.class);
    private JNDIUtil jndiUtil;
    private boolean enabled = true;

    public Rule(JNDIUtil util) {
        this.jndiUtil = util;
    }

    public final void load() {
        Boolean jndiValue = this.jndiUtil != null ? this.jndiUtil.getJndiBooleanValue("param/" + this.getClass().getSimpleName() + "/enabled", false) : null;
        this.enabled = jndiValue == null || jndiValue.booleanValue();
    }

    public abstract void init();

    protected abstract OUTPUT_TYPE doEvaluate(INPUT_TYPE var1) throws RuleException;

    protected abstract boolean isApplicable(INPUT_TYPE var1);

    public OUTPUT_TYPE evaluate(INPUT_TYPE input) throws RuleException {
        if (this.enabled && this.isApplicable(input)) {
            log.debug("Evaluating rule: " + this.getClass().getSimpleName() + " for input: " + input.toString());
            return this.doEvaluate(input);
        } else {
            return null;
        }
    }

    protected JNDIUtil getJndiUtil() {
        return this.jndiUtil;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
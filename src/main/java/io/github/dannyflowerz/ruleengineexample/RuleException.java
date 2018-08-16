package io.github.dannyflowerz.ruleengineexample;

public class RuleException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RuleException(String str) {
        super(str);
    }
}
package io.github.dannyflowerz.ruleengineexample.example;

import lombok.ToString;

@ToString
public class Input {

    public enum Discriminator {
        FOO,
        BAR
    }

    Discriminator discriminator;

    public Input(Discriminator discriminator) {
        this.discriminator = discriminator;
    }

}

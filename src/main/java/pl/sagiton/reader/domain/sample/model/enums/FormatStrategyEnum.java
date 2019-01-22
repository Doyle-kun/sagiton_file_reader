package pl.sagiton.reader.domain.sample.model.enums;

import pl.sagiton.reader.domain.sample.strategy.format.F1Strategy;
import pl.sagiton.reader.domain.sample.strategy.format.F2Strategy;
import pl.sagiton.reader.domain.sample.strategy.format.FormatStrategy;


public enum FormatStrategyEnum {
    F1(new F1Strategy()),
    F2(new F2Strategy());
    private FormatStrategy formatStrategy;

     FormatStrategyEnum(FormatStrategy formatStrategy) {
        this.formatStrategy = formatStrategy;
    }

    public FormatStrategy getObject() {
        return formatStrategy;
    }
}

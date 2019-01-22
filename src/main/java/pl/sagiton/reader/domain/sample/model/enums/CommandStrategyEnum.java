package pl.sagiton.reader.domain.sample.model.enums;

import pl.sagiton.reader.domain.sample.strategy.command.CityStrategy;
import pl.sagiton.reader.domain.sample.strategy.command.CommandStrategy;
import pl.sagiton.reader.domain.sample.strategy.command.IdStrategy;


public enum CommandStrategyEnum {
    ID(new IdStrategy()),
    CITY(new CityStrategy());
    private CommandStrategy commandStrategy;

    CommandStrategyEnum(CommandStrategy commandStrategy) {
        this.commandStrategy = commandStrategy;
    }

    public CommandStrategy getObject() {
        return commandStrategy;
    }

}

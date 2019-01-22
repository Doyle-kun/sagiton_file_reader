package strategy.command;

import org.junit.jupiter.api.Test;
import pl.sagiton.reader.domain.sample.model.enums.CommandStrategyEnum;
import pl.sagiton.reader.domain.sample.strategy.command.CityStrategy;
import pl.sagiton.reader.domain.sample.strategy.command.CommandContext;
import pl.sagiton.reader.domain.sample.strategy.command.CommandStrategy;
import pl.sagiton.reader.domain.sample.strategy.command.IdStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandStrategyTest {
    private static final String ID_STRATEGY = "ID";
    private static final String CITY_STRATEGY = "CITY";
    private static final String NON_EXISTING_STRATEGY = "NAME";

    @Test
    public void shouldChooseIdStrategy(){
        CommandContext context = new CommandContext();
        CommandStrategyEnum commandStrategyEnum = CommandStrategyEnum.valueOf(ID_STRATEGY);
        assertEquals(CommandStrategyEnum.ID, commandStrategyEnum);
        CommandStrategy strategy = commandStrategyEnum.getObject();
        assertEquals(IdStrategy.class, strategy.getClass());
        context.setStrategy(strategy);
        assertEquals(IdStrategy.class, context.getStrategy().getClass());

    }

    @Test
    public void shouldChooseCityStrategy(){
        CommandContext context = new CommandContext();
        CommandStrategyEnum commandStrategyEnum = CommandStrategyEnum.valueOf(CITY_STRATEGY);
        assertEquals(CommandStrategyEnum.CITY, commandStrategyEnum);
        CommandStrategy strategy = commandStrategyEnum.getObject();
        assertEquals(CityStrategy.class, strategy.getClass());
        context.setStrategy(strategy);
        assertEquals(CityStrategy.class, context.getStrategy().getClass());
    }

    @Test
    public void shouldThrowIllealArgumentExceptionForNotExistingStrategy(){
        assertThrows(IllegalArgumentException.class, ()->CommandStrategyEnum.valueOf(NON_EXISTING_STRATEGY));
    }
}

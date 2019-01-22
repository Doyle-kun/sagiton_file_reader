package strategy.format;

import org.junit.jupiter.api.Test;
import pl.sagiton.reader.domain.sample.model.enums.FormatStrategyEnum;
import pl.sagiton.reader.domain.sample.strategy.format.F1Strategy;
import pl.sagiton.reader.domain.sample.strategy.format.F2Strategy;
import pl.sagiton.reader.domain.sample.strategy.format.FormatContext;
import pl.sagiton.reader.domain.sample.strategy.format.FormatStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FormatStrategyTest {
    private static final String FIRST_STRATEGY = "F1";
    private static final String SECOND_STRATEGY = "F2";
    private static final String NON_EXISTING_STRATEGY = "Z3";

    @Test
    public void shouldChooseFirstStrategy(){
        FormatContext context = new FormatContext();
        FormatStrategyEnum formatStrategyEnum = FormatStrategyEnum.valueOf(FIRST_STRATEGY);
        assertEquals(FormatStrategyEnum.F1, formatStrategyEnum);
        FormatStrategy strategy = formatStrategyEnum.getObject();
        assertEquals(F1Strategy.class, strategy.getClass());
        context.setStrategy(strategy);
        assertEquals(F1Strategy.class, context.getStrategy().getClass());

    }

    @Test
    public void shouldChooseSecondStrategy(){
        FormatContext context = new FormatContext();
        FormatStrategyEnum formatStrategyEnum = FormatStrategyEnum.valueOf(SECOND_STRATEGY);
        assertEquals(FormatStrategyEnum.F2, formatStrategyEnum);
        FormatStrategy strategy = formatStrategyEnum.getObject();
        assertEquals(F2Strategy.class, strategy.getClass());
        context.setStrategy(strategy);
        assertEquals(F2Strategy.class, context.getStrategy().getClass());
    }

    @Test
    public void shouldThrowIllealArgumentExceptionForNotExistingStrategy(){
        assertThrows(IllegalArgumentException.class, ()->FormatStrategyEnum.valueOf(NON_EXISTING_STRATEGY));
    }
}

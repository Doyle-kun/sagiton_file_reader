package pl.sagiton.reader.domain.sample.strategy.command;

import lombok.Getter;
import lombok.Setter;
import pl.sagiton.reader.domain.sample.model.Result;

@Getter
@Setter
public class CommandContext {
    private CommandStrategy strategy;

    public String filter(Result result, String val) {
        return strategy.filterResponse(result, val);
    }
}

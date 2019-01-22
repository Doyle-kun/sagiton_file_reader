package pl.sagiton.reader.domain.sample.strategy.command;

import pl.sagiton.reader.domain.sample.model.Result;

public class IdStrategy implements CommandStrategy {
    @Override
    public String filterResponse(Result result, String val) {
        final String EMPTY = "";
        if (result.getId().equals(val)){
            return result.getCity().toUpperCase();
        }
        return EMPTY;
    }
}

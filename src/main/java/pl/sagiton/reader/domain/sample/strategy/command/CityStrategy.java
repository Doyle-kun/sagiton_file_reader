package pl.sagiton.reader.domain.sample.strategy.command;

import pl.sagiton.reader.domain.sample.model.Result;

public class CityStrategy implements CommandStrategy {
    @Override
    public String filterResponse(Result result, String val) {
        final String EMPTY = "";
        if (result.getCity().toUpperCase().equals(val.toUpperCase())){
            return result.getName() +" " + result.getId();
        }
        return EMPTY;
    }
}

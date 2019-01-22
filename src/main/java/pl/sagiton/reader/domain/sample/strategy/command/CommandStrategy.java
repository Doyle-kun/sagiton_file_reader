package pl.sagiton.reader.domain.sample.strategy.command;

import pl.sagiton.reader.domain.sample.model.Result;

public interface CommandStrategy {
    String filterResponse(Result result, String val);
}

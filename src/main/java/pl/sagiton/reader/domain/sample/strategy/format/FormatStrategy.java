package pl.sagiton.reader.domain.sample.strategy.format;

import pl.sagiton.reader.domain.sample.model.Result;

public interface FormatStrategy {
    Result find(String line);
}

package pl.sagiton.reader.domain.sample.strategy.format;

import lombok.NoArgsConstructor;
import pl.sagiton.reader.domain.sample.model.Result;

@NoArgsConstructor
public class F1Strategy implements FormatStrategy {

    @Override
    public Result find(String line) {
        String[] parts = line.split(",");
        return new Result(parts[0].trim(), parts[1].trim(), parts[2].trim());
    }
}

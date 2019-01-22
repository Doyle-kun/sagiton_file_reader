package pl.sagiton.reader.domain.sample.strategy.format;

import pl.sagiton.reader.domain.sample.model.Result;

public class F2Strategy implements FormatStrategy {
    @Override
    public Result find(String line) {
        String[] parts = line.split(";");
        return new Result(parts[0].trim(), parts[1].trim(), parts[2].replace("-", "").trim());
    }
}

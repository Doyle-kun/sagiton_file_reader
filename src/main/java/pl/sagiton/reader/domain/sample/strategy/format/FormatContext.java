package pl.sagiton.reader.domain.sample.strategy.format;

import lombok.Getter;
import lombok.Setter;
import pl.sagiton.reader.domain.sample.model.Result;

@Getter
@Setter
public class FormatContext {
    private FormatStrategy strategy;

    public Result formatLine(String line){
        return strategy.find(line);
    }
}

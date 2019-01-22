package pl.sagiton.reader.domain.sample;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import pl.sagiton.reader.domain.sample.model.Result;
import pl.sagiton.reader.domain.sample.model.enums.CommandStrategyEnum;
import pl.sagiton.reader.domain.sample.model.enums.FormatStrategyEnum;
import pl.sagiton.reader.domain.sample.strategy.command.CommandContext;
import pl.sagiton.reader.domain.sample.strategy.command.CommandStrategy;
import pl.sagiton.reader.domain.sample.strategy.format.FormatContext;
import pl.sagiton.reader.domain.sample.strategy.format.FormatStrategy;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

@NoArgsConstructor
public class DataProcessor {

    @SneakyThrows
    public void processFile(FormatContext ctx, String path, String cmd, String cmdValue) {
        final String DATA_PREFIX = "D";
        final String FORMAT_PREFIX = "F";
        try (Stream<String> stringStream = Files.lines(Paths.get(path))) {
            stringStream.map(line -> {
                if (line.toUpperCase().startsWith(FORMAT_PREFIX)) {
                    setFormatStrategy(ctx, line);
                }
                if (line.startsWith(DATA_PREFIX)) {
                    Result result = ctx.formatLine(line.substring(DATA_PREFIX.length()));
                    return evaluateResultToMatchers(result, cmd, cmdValue);
                }
                return Optional.empty();
            }).filter(Optional::isPresent).map(Optional::get).distinct().forEach(r -> System.out.println(r));
        }
    }

    private Optional<String> evaluateResultToMatchers(Result result, String cmd, String cmdValue) {
        CommandContext context = new CommandContext();
        CommandStrategy strategy = CommandStrategyEnum.valueOf(cmd).getObject();
        if (strategy == null) {
            throw new IllegalStateException();
        }
        context.setStrategy(strategy);
        String filteredResult = context.filter(result, cmdValue);
        if (!filteredResult.isEmpty()) {
            return Optional.of(filteredResult);
        }
        return Optional.empty();
    }

    private void setFormatStrategy(FormatContext ctx, String line) {
        line = line.toUpperCase().trim();
        if (line.length() != 2) {
            throw new IllegalStateException();
        }
        FormatStrategy strategy = FormatStrategyEnum.valueOf(line)
            .getObject();
        if (strategy == null) {
            throw new IllegalStateException();
        }
        ctx.setStrategy(strategy);
    }

}

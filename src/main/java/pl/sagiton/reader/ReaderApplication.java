package pl.sagiton.reader;

import pl.sagiton.reader.domain.sample.DataProcessor;
import pl.sagiton.reader.domain.sample.strategy.format.FormatContext;

public class ReaderApplication {

    public static void main(String[] args) {
        if (args.length != 3){
            throw new IllegalStateException();
        }
        String path = args[0];
        String cmd = args[1];
        String cmdValue = args[2];

        long start = System.nanoTime();

        FormatContext ctx = new FormatContext();
        DataProcessor dataProcessor = new DataProcessor();
        dataProcessor.processFile(ctx, path, cmd, cmdValue);

        long stop = System.nanoTime();
        System.out.println("Execution time: " + ((stop - start) / 1000000) +  "ms");
    }

}

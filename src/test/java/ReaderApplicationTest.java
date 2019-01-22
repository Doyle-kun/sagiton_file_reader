import org.junit.jupiter.api.Test;
import pl.sagiton.reader.ReaderApplication;
import pl.sagiton.reader.domain.sample.DataProcessor;
import pl.sagiton.reader.domain.sample.strategy.format.FormatContext;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReaderApplicationTest {
    private static final String filePath = "src/test/resources/file";
    private static final String ID = "ID";
    private static final String ID_VALUE = "58202263G";

    @Test
    public void shouldThrowIllegalStateExceptionWhenMissingValueOfParameter(){
        assertThrows(IllegalStateException.class, () -> ReaderApplication.main(new String[] {filePath, ID}));
    }
    @Test
    public void shouldThrowIllegalStateExceptionWhenMissingCommandParameter(){
        assertThrows(IllegalStateException.class, () -> ReaderApplication.main(new String[] {filePath, ID_VALUE}));
    }
    @Test
    public void shouldThrowIllegalStateExceptionWhenMissingPath(){
        assertThrows(IllegalStateException.class, () -> ReaderApplication.main(new String[] {ID, ID_VALUE}));
    }
}

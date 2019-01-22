import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import pl.sagiton.reader.domain.sample.DataProcessor;
import pl.sagiton.reader.domain.sample.strategy.format.FormatContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DataProcessorTest {

private static final String filePath = "src/test/resources/file";
private static final String emptyFilePath = "src/test/resources/empty";
private static final String ID = "ID";
private static final String CITY = "CITY";
private static final String ID_VALUE = "58202263G";
private static final String CITY_NAME = "SEVILLA";
private static final String EXPECTED_NAME_ID = "Neal Love 52498689Q\n";
private static final String EXPECTED_CITY = "LISBOA\nLONDRES\nLAS VEGAS\n";
private static final String NON_EXISTING_CITY = "WROCLAW";
private static final String NON_EXISTING_ID = "12345Z";
private static final String EMPTY_STRING = "";


    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void revertStreams() {
        System.setOut(sysOut);
    }
    @Test
    public void shouldDisplayCitiesById(){
        DataProcessor dataProcessor = new DataProcessor();
        FormatContext formatContext = new FormatContext();
        dataProcessor.processFile(formatContext, filePath, ID, ID_VALUE);
        assertEquals(EXPECTED_CITY ,outContent.toString());
    }
    @Test
    public void shouldDisplayNameAndIdByCity(){
        DataProcessor dataProcessor = new DataProcessor();
        FormatContext formatContext = new FormatContext();
        dataProcessor.processFile(formatContext, filePath, CITY, CITY_NAME);
        assertEquals(EXPECTED_NAME_ID,outContent.toString());
    }
    @Test
    public void shouldReturnEmptyListWithNonexistingCity(){
        DataProcessor dataProcessor = new DataProcessor();
        FormatContext formatContext = new FormatContext();
        dataProcessor.processFile(formatContext, filePath, CITY, NON_EXISTING_CITY);
        assertEquals(EMPTY_STRING,outContent.toString());
    }
    @Test
    public void shouldReturnEmptyListWithNonexistingId(){
        DataProcessor dataProcessor = new DataProcessor();
        FormatContext formatContext = new FormatContext();
        dataProcessor.processFile(formatContext, filePath, ID, NON_EXISTING_ID);
        assertEquals(EMPTY_STRING ,outContent.toString());
    }
    @Test
    public void shouldReturnEmptyNameIdListWithEmptyFile(){
        DataProcessor dataProcessor = new DataProcessor();
        FormatContext formatContext = new FormatContext();
        dataProcessor.processFile(formatContext, emptyFilePath, CITY, NON_EXISTING_CITY);
        assertEquals(EMPTY_STRING,outContent.toString());
    }
    @Test
    public void shouldReturnEmptyCityListWithEmptyFile(){
        DataProcessor dataProcessor = new DataProcessor();
        FormatContext formatContext = new FormatContext();
        dataProcessor.processFile(formatContext, filePath, ID, NON_EXISTING_ID);
        assertEquals(EMPTY_STRING ,outContent.toString());
    }
}

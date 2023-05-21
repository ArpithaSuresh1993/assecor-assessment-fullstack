package backend.restservices.filereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  CSV file reader
 */
public class CsvFileReader {
    public List<String> readLines(String aFileName)
    {
        List<String> lines = new ArrayList<>();

        try(
                InputStream inputStream = this.getClass().getResourceAsStream("/"+aFileName);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        )
        {
            String line = "";

            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

        } catch(final IOException aException) {
            Logger.getLogger( getClass().getName() )
                    .log( Level.SEVERE, "Cannot read lines from file " + aFileName, aException );
        }
        return lines;
    }
}

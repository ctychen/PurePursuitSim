import java.io.*;
import java.util.*;

/**
 * Self-explanatory utilities for reading and writing CSV files
 */
public class CSVTranslator {

    public static double[][] parseCSV(File file) throws FileNotFoundException {
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream = new Scanner(file);

        double[][] returnMe;

        while (inputStream.hasNext()) {
            String line = inputStream.next();
            String[] values = line.split(",");

            lines.add(Arrays.asList(values));
        }

        inputStream.close();

        returnMe = new double[lines.size()][lines.get(0).size()];

        int lineNum = 0;
        for (List<String> line : lines) {
            int columnNum = 0;

            for (String val : line) {
                returnMe[lineNum][columnNum] = Double.parseDouble(val);
                columnNum++;
            }

            lineNum++;
        }
        return returnMe;
    }

    public static void writeCSV(ArrayList<CSV> array, File writeTo) throws IOException {
        FileWriter writer = new FileWriter(writeTo);
        String writeMe = "";
        
        for (CSV vals : array) {
        	writeMe += vals.name;
        	writeMe += ",";
        }

        writeMe += "\n";
        for (int i = 0; i < array.get(0).log.size(); i++) {
            for (CSV vals : array) {
                writeMe += vals.log.get(i).toString();
                writeMe += ",";
            }
            writeMe += "\n";
        }

        writer.write(writeMe);
        writer.close();
    }
    
    
}

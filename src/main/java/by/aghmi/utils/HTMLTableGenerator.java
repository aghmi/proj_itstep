package by.aghmi.utils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class HTMLTableGenerator {
    private static int columns;
    private static StringBuilder table = new StringBuilder();
    private static String BEGIN = "<html>";
    private static String END = "</html>";
    private static String TABLE_BEGIN = "<table>";
    private static String TABLE_END = "</table>";
    private static String HEADER_BEGIN = "<th>";
    private static String HEADER_END = "</th>";
    private static String ROW_BEGIN = "<tr>";
    private static String ROW_END = "</tr>";
    private static String COLUMN_BEGIN = "<td>";
    private static String COLUMN_END = "</td>";
    
    public static StringBuilder getTable() {
		return table;
	}
    
    public HTMLTableGenerator(int columns) {
        HTMLTableGenerator.columns = columns;
        table.append(BEGIN);
        table.append(TABLE_BEGIN);
        table.append(TABLE_END);
        table.append(END);
        System.out.println(" Stage I: " + table.toString());
    }
    
    
    public void addHeaders(String... values){
        if(values.length != columns){
            System.err.println("Error column length");
        } else {
            int lastIndex = table.lastIndexOf(TABLE_END);
            if(lastIndex > 0){
                StringBuilder sb = new StringBuilder();
                sb.append(ROW_BEGIN);
                for (int i = 0; i < values.length; i++) {
                    sb.append(HEADER_BEGIN);
                    sb.append(values[i]);
                    sb.append(HEADER_END);
                }
                sb.append(ROW_END);
                table.insert(lastIndex, sb.toString());
                System.out.println(" Stage II: " + table.toString());
            } 
        }
    }
    
    public void addRowsData(String... values){
        if(values.length != columns){
            System.err.println("Error column length");
        } else {
            int lastIndex = table.lastIndexOf(ROW_END);
            if(lastIndex > 0){
                int index = lastIndex + ROW_END.length();
                StringBuilder sb = new StringBuilder();
                sb.append(ROW_BEGIN);
                for (int i = 0; i < values.length; i++) {
                    sb.append(COLUMN_BEGIN);
                    sb.append(values[i]);
                    sb.append(COLUMN_END);
                }
                sb.append(ROW_END);
                table.insert(index, sb.toString());
                System.out.println(" Stage III: " + table.toString());
            } 
        }
    }
    
    
    public String build(){
        return table.toString();
    }
    
    public static void main(String[] args) {
        HTMLTableGenerator gen = new HTMLTableGenerator(4);
        gen.addHeaders("Firstname", "Lastname", "Age" , "Gender");
        gen.addRowsData("Alex", "Ivanov", "32" , "M");
        gen.addRowsData("John", "Johnson", "32", "M");
        gen.addRowsData("Bob", "Bobson", "32", "M");
        
        BufferedWriter bw  = null;
        try {
            FileWriter wr = new FileWriter("D:/table.html");
            bw = new BufferedWriter(wr);
            bw.write(gen.build());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        System.out.println(gen.build());
        
        
    }
}


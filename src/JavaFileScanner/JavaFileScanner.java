package JavaFileScanner;

/**
 * Created by namrataojha on 7/6/16.
 * Different example to get data from csv file
 * http://howtodoinjava.com/core-java/related-concepts/parse-csv-files-in-java/
 */
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class JavaFileScanner {

    public static void main(String[] args) throws IOException {
        /**
         *  My Name is Pankaj
         *  My website is journaldev.com
         *  Phone : 1234567890
         */
        String fileName = "/Users/namrataojha/Documents/Java/source.txt";
        Path path = Paths.get(fileName);
        System.out.println("path: "+path);
        Scanner scanner = new Scanner(path);

        //read file line by line
        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()){
            System.out.println("Lines: "+scanner.next());
        }
        scanner.close();
        //read CSV Files and parse it to object array
        /**
         * Pankaj,28,Male
         * Lisa,30,Female
         * Mike,25,Male
         */
        scanner = new Scanner(Paths.get("/Users/namrataojha/Documents/Java/data.csv"));
        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()){
            //parse line to get Emp Object
            Employee emp = parseCSVLine(scanner.next());
            System.out.println(emp.toString());
        }
        scanner.close();

        //read from system input
        System.out.println("Read from system input:");
        scanner = new Scanner(System.in);
        System.out.println("Input first word: "+scanner.next());
    }
//    We are using regex \\s*,\\s*.
//
// \s matches any whitespace, The * applies the match zero or more times.
// So \s* means “match any white space zero or more times”. We look for this before and after the comma.
// Therefore, the split will work for strings like "company1 ,company2 ,  company3", or "company1,company2,company3", etc.
// In Java, you need to escape the backslash in strings, so you get \\s*.
//

    private static Employee parseCSVLine(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter("\\s*,\\s*");
        String name = scanner.next();
        int age = scanner.nextInt();
        String gender = scanner.next();
        JavaFileScanner jfs = new JavaFileScanner();
        return jfs.new Employee(name, age, gender);
    }

    public class Employee{
        private String name;
        private int age;
        private String gender;

        public Employee(String n, int a, String gen){
            this.name = n;
            this.age = a;
            this.gender = gen;
        }

        @Override
        public String toString(){
            return "Name="+this.name+"::Age="+this.age+"::Gender="+this.gender;
        }
    }

}

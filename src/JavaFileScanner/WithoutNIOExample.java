package JavaFileScanner;

/**
 * Created by namrataojha on 7/6/16.
 * Old famous I/O way

 This example shows how we have been reading a text file using old I/O library APIs. It uses a BufferedReader object for reading.
 Another way can be using InputStream implementation.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WithoutNIOExample
{
    public static void main(String[] args)
    {
        BufferedReader br = null;
        String sCurrentLine = null;
        try
        {
            br = new BufferedReader(
                    new FileReader("/Users/namrataojha/Documents/Java/source.txt"));
            while ((sCurrentLine = br.readLine()) != null)
            {
                System.out.println(sCurrentLine);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (br != null)
                    br.close();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}

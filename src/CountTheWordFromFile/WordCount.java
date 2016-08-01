package CountTheWordFromFile;

/**
 * Created by namrataojha on 6/16/16.
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class WordCount {

    public Map<String, Integer> getWordCount(String fileName){
//Reading Value using BufferedReader
        FileInputStream inputStream = null;
        DataInputStream dataInputStream = null;
        BufferedReader bufferedReader = null;
        Map<String, Integer> stringIntegerMap = new HashMap<String, Integer>();
        try {
            inputStream = new FileInputStream(fileName);
            dataInputStream = new DataInputStream(inputStream);
            bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line, " ");
                while(st.hasMoreTokens()){
                    String tmp = st.nextToken().toLowerCase();
                    if(stringIntegerMap.containsKey(tmp)){
                        stringIntegerMap.put(tmp, stringIntegerMap.get(tmp)+1); // increasing the count if word is repeated
                    } else {
                        stringIntegerMap.put(tmp, 1); // Storing the value in stringIntegerMap with count 1
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{if(bufferedReader != null) bufferedReader.close();}catch(Exception ex){}
        }
        return stringIntegerMap;
    }

    public List<Entry<String, Integer>> sortWords(Map<String, Integer> wordMap){
// sorting the value
        Set<Entry<String, Integer>> set = wordMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        return list;
    }

    public static void main(String a[]){
        WordCount mdc = new WordCount();
        Map<String, Integer> wordMap = mdc.getWordCount("/Users/namrataojha/Downloads/tt.txt");
        List<Entry<String, Integer>> list = mdc.sortWords(wordMap);
        for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+" ====>>> "+entry.getValue());
        }
    }
}


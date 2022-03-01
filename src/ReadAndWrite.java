import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void main(String[] args) {
        ReadAndWrite raw = new ReadAndWrite();
        List<Integer> numbers = raw.readFile("numbers.txt");
        int maxValue = findMax(numbers);
        raw.writeFile("result.txt",maxValue);
    }







    public List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try{
            File file = new File(filePath);
            if (!file.exists())
                throw new FileNotFoundException();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = " ";
            while ((line = br.readLine()) != null){
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        }catch (Exception e) {
            System.out.println("File not exist or content has an error");
        }
        return numbers;
    }

    public void writeFile(String filePath, int max){
        try{
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("Max = " + max);
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findMax (List<Integer> numbers){
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (max < number)
                max = number;
        }
        return max;
    }
}

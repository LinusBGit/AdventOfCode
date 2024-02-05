import java.io.*;

public class day_one {
    public static void main(String[] args) throws Exception
    {
        String filePath = "day_one/data/input.txt";
        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int first = 0, second = 0, third = 0, count = 0;
        int holder;
        while ((st = br.readLine()) != null)
        {
            if(st.isEmpty()){
                if(count>=first){
                    holder = second;
                    second = first;
                    third = holder;
                    first = count;
                    count = 0;
                } 
                else if(count>=second){
                    third = second;
                    second = count;
                    count = 0;
                } 
                else if(count>=third){
                    third = count;
                    count = 0;
                } 
                count = 0;
            }
            else count += Integer.parseInt(st); 
        }
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(first+second+third);

        br.close();
            
    }
}
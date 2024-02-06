import java.io.*;

public class day_one {
    public static void main(String[] args) throws Exception
    {
        String filePath = "data/input.txt";
        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int first = 0, second = 0, third = 0, count = 0;
        int holder;
        while ((st = br.readLine()) != null)
        {
            if(st.isEmpty()){
                // If greater than first - Using holder as a temp value to perform the swap
                if(count>=first){
                    holder = second;
                    second = first;
                    third = holder;
                    first = count;
                    count = 0;
                } 
                // If greater than or equal to second but smaller than first
                else if(count>=second){
                    third = second;
                    second = count;
                    count = 0;
                } // If greater than third but smaller than first and second
                else if(count>third){
                    third = count;
                    count = 0;
                } 
                count = 0;
            }
            else count += Integer.parseInt(st); 
        }
        // Print out the elf carrying the most calories, second most calories, third most calories, and the sum of those three
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(first+second+third);

        br.close();
            
    }
}
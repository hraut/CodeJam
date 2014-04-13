import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemA {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try{
            File ifile = new File(args[0]);
            File ofile = new File(args[1]);

            Scanner in = new Scanner(ifile);
            PrintWriter out = new PrintWriter(ofile);

            int T = in.nextInt();
            for(int ti=0;ti<T;ti++ ){
                String s = solve(in,out);
                out.format("Case #%d: %s\n", ti+1, s);
            }
            out.flush();
            in.close();
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static String solve(Scanner in, PrintWriter out){
        String res = null;
        Set<Integer> set1 = new HashSet<Integer>(); 
        Set<Integer> set2 = new HashSet<Integer>(); 
        int answer1= in.nextInt();
        String line  = in.nextLine();
        for(int j=1;j<=4;j++){
             if(j==answer1){
                for(int k=0;k<4;k++){
                    set1.add(in.nextInt());
                }
            }
            line  = in.nextLine();
        }
        int answer2 = in.nextInt();
        in.nextLine();
        for(int j=1;j<=4;j++){
            if(j==answer2){
                for(int k=0;k<4;k++){
                    set2.add(in.nextInt());
                }
            }
            line = in.nextLine();
        }
                
        Set<Integer> union = new HashSet<Integer>(set1);
        union.addAll(set2);
        if(union.size()==8)
            return "Volunteer cheated!";
        Set<Integer> intersection = new HashSet<Integer>(set1);
        intersection.retainAll(set2);
        if(intersection.size()!=1){
            return "Bad magician!";
        }
        else{
            int val = 0;
            for(Integer i:intersection){
                val = i;
            }
              return ""+val;
        }
          
    }
}


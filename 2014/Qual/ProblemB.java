import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ProblemB {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try{
            File ifile = new File(args[0]);
            File ofile = new File(args[1]);

            Scanner in = new Scanner(ifile);
            PrintWriter out = new PrintWriter(ofile);

            int T = in.nextInt();
            for(int ti=0;ti<T;ti++ ){
                double s = solve(in,out);
                out.format("Case #%d: %.7f\n", ti+1, s);
            }
            out.flush();
            in.close();
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static double solve(Scanner in, PrintWriter out){
        double C,F,X,R;
        C= in.nextDouble();
        F= in.nextDouble();
        X= in.nextDouble();
        R = 2;
        double prevTime, currTime;
        ArrayList<Double> values = new ArrayList<Double>();
        
        prevTime = X/R;
        currTime = C/R + X/(R+F);
        values.add(C/R);
        int count = 0;
        while(currTime < prevTime){    
            prevTime = currTime;
            R = R+F;
            values.add(values.get(count) + C/R);
            currTime = values.get(count) + C/R + X/(R+F);
            count++;
        }
        return prevTime;
        
    }
}


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class ProblemD {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try{
            File ifile = new File(args[0]);
            File ofile = new File(args[1]);

            Scanner in = new Scanner(ifile);
            PrintWriter out = new PrintWriter(ofile);

            int T = in.nextInt();
            for(int ti=0;ti<T;ti++ ){
                solve(in,out,ti);
            }
            out.flush();
            in.close();
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static void solve(Scanner in, PrintWriter out, int ti){
        
        int N;
        int dw=0,w=0;
        N = in.nextInt();
        double[] X = new double[N];
        double[] Y = new double[N];
        for(int i=0;i<N;i++){
            X[i] = in.nextDouble();
        }
        for(int i=0;i<N;i++){
            Y[i] = in.nextDouble();
        }
        Arrays.sort(X);
        Arrays.sort(Y);
        
        
        /*for(int i=0;i<N;i++){
            if(X[i]>Y[i])
                dw++;
        }*/
        
        int i=0,j=0;
        while(i<N){
            if(X[i]>Y[j]){
                i++;j++;dw++;        
            }else{
                i++;
            }
        }
        
        
        // Find wins in war
        i=0;
        j=0;
        while(j<N){
            if(Y[j]>X[i]){
                i++;
                j++;
                w++;
            }
            else{
                j++;
            }
        }
        
        out.format("Case #%d: %d %d\n", ti+1, dw, N-w);    
    }
}


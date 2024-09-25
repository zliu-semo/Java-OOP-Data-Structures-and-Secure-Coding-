package client;
import res.*;

public class JavaIOEx5_ObjectStream {

    public static void main(String[] args) {
        NestingDoll d1 = new NestingDoll();
        NestingDoll d2 = new NestingDoll("striped", d1);
        NestingDoll d3 = new NestingDoll("dotted", d2);
        NestingDoll d4 = new NestingDoll("houndstooth", d3);
        NestingDoll d5 = new NestingDoll("floral", d4);
        
        NestingDoll[] dolls = {d5, d4, d3, d2, d1};
        Processor.writeObjects("files/nesting-dolls.txt", dolls);
        Processor.readObjects("files/nesting-dolls.txt");
        
        int n = dolls.length;
        NestingDoll[] clones = new NestingDoll[n];
        for (int i = 0; i < n; i++) {
            clones[i] = dolls[i].clone();
        }
        Processor.writeObjects("files/nesting-dolls-clones.txt", clones);
        Processor.readObjects("files/nesting-dolls-clones.txt");
        
        NestingDoll[] reversed = {d1, d2, d3, d4, d5};
        Processor.writeObjects("files/nesting-dolls-reversed.txt", reversed);
        Processor.readObjects("files/nesting-dolls-reversed.txt");
    }
}

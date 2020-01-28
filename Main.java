package gr.hua.dit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        FileHandler fileHandler2 = new FileHandler();
        List<GCpair> gCpairsSerial = fileHandler.readDNAFiles("100K.results");
        List<GCpair> gCpairsParallel = fileHandler2.readDNAFiles("100K.res_omp");
        System.out.println(gCpairsSerial.size());
        System.out.println(gCpairsParallel.size());
        gCpairsSerial.sort((o1, o2) -> {
            if(Double.compare(o1.getGC(), o2.getGC()) == 0)
                return o1.getSequence().compareTo(o2.getSequence());
            else
                return Double.compare(o1.getGC(), o2.getGC());

        });
        gCpairsParallel.sort((o1, o2) -> {
            if(Double.compare(o1.getGC(), o2.getGC()) == 0)
                return o1.getSequence().compareTo(o2.getSequence());
            else
                return Double.compare(o1.getGC(), o2.getGC());

        });

        boolean identical = true;
        for (int i = 0; i < gCpairsSerial.size(); i++) {
            if( gCpairsSerial.get(i).getGC() != gCpairsParallel.get(i).getGC() ){
                identical = false;
                break;
            }
        }

        for (int i = 0; i < gCpairsSerial.size(); i++) {
            if( !gCpairsSerial.get(i).getSequence().equals(gCpairsParallel.get(i).getSequence()) ){
                System.out.println(gCpairsSerial.get(i).getSequence()+"\n"+gCpairsParallel.get(i).getSequence()+"\n " + i);
                identical = false;
                break;
            }
        }
        if(identical)
            System.out.println("Identical");
        else
            System.out.println("Different");

//        for (int i = 0; i < 10; i++) {
//                System.out.println(gCpairsSerial.get(i)+"||"+gCpairsParallel.get(i));
//        }
}
    }


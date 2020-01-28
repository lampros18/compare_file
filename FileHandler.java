package gr.hua.dit;

import sun.misc.GC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    public List<GCpair> readDNAFiles(String filename){
        File data = new File("C:\\Users\\Lampros\\Desktop\\diff_checker\\src\\gr\\hua\\dit\\"+filename);
        String lineText;
        String[] tokens;
        List<GCpair> gCpairs = new ArrayList<>();
        try (Scanner sc = new Scanner(data)) {

            while (sc.hasNextLine()) {
                lineText = sc.nextLine();
                tokens = lineText.split("\t", 2);
                gCpairs.add(new GCpair(Double.parseDouble(tokens[0]), tokens[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return gCpairs;
    }
}

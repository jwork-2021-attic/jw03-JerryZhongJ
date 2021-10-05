package S181870286;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import example.classloader.SteganographyClassLoader;

public class Scene {
    public static void main(String[] args) throws Exception {
        Line line = new Line(64);
        ArrayList<Integer> sequence = new ArrayList<Integer>(64);
        for (int i = 0; i < 64; i++) {
            sequence.add(i);
        }
        Collections.shuffle(sequence);
        for (int i = 0; i < 64; i++) {
            line.put(new Goblin(255, i * 4, i * 4, i), sequence.get(i));
        }
        Snake theSnake = Snake.getTheSnake();
        
        SteganographyClassLoader loader = new SteganographyClassLoader(
                new File("S181870286/resources/S181870286.QuickSorter.png").toURI().toURL());

        Class c;
        
        c = loader.loadClass("S181870286.QuickSorter");
       

        Sorter sorter = null;
        
        sorter = (Sorter) c.getDeclaredConstructor().newInstance();
       

        theSnake.setSorter(sorter);

        String log = theSnake.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();
    }
}

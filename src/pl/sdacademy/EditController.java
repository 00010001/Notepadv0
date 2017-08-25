package pl.sdacademy;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-25.
 */
public class EditController {

    @FXML
    TextArea editTextArea;

    @FXML
    Tab tab;

    File file;

    public void initialize(File file)  {
        this.file = file;
        Scanner s = null;
        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNext()) {
            if (s.hasNextInt()) { // check if next token is an int
                editTextArea.appendText(s.nextInt() + " "); // display the found integer
            } else {
                editTextArea.appendText(s.next() + " "); // else read the next token
            }
        }

        tab.setText(file.getName());
    }

    public void saveToFile(){
        ObservableList<CharSequence> paragraph = editTextArea.getParagraphs();
        Iterator<CharSequence> iter = paragraph.iterator();
        try
        {
            BufferedWriter bf = new BufferedWriter(new FileWriter(file));
            while(iter.hasNext())
            {
                CharSequence seq = iter.next();
                bf.append(seq);
                bf.newLine();
            }
            bf.flush();
            bf.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

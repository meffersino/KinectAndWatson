import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DeleteClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Delete {

    private static VisualRecognition service;
    public static void main(String[] args) {

        service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);

        service.setApiKey("fb4201a556bd26be9ad01fef1c95bc23f3fb3aed");
        String fileName = "C:/Users/Michael/Documents/Uni/MEng/Code/save_files/classifierIDSave.txt";

        try {
            PrintWriter writer = new PrintWriter(fileName);

        } catch (FileNotFoundException e) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        }


    }
}

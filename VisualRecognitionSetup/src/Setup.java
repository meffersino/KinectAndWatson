import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Classifier;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CreateClassifierOptions;

import java.io.File;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Setup {

    private static VisualRecognition service;
    public static void main(String[] args) {

        service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);

        service.setApiKey("fb4201a556bd26be9ad01fef1c95bc23f3fb3aed");

        String directory = "C:/Users/Michael/Documents/Uni/MEng/Code/";
        try {
            CreateClassifierOptions createClassifierOptions = new CreateClassifierOptions.Builder()
                    .name("table")
                    .addClass("wooden", new File(directory + "Images/wooden.zip"))
                    .addClass("glass", new File(directory + "Images/glass.zip"))
                    .negativeExamples(new File(directory + "Images/chair.zip"))
                    .build();
            Classifier table = service.createClassifier(createClassifierOptions).execute();

            Writer writer = null;
            String fileName = directory + "save_files/classifierIDSave.txt";

            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(fileName), "utf-8"));
                writer.write(table.getClassifierId());
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

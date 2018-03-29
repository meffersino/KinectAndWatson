import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Classifier;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CreateClassifierOptions;

import java.io.*;

public class Setup {

    private static VisualRecognition service;
    /*public static void main(String[] args) {

        service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);

        service.setApiKey("fb4201a556bd26be9ad01fef1c95bc23f3fb3aed");

        String directory = "C:/Users/Michael/Documents/Uni/MEng/Code/KinectAndWatson/";
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
    }*/

    public Setup(VisualRecognition newService, String newDirectory) {
        service = newService;
        String directory = newDirectory;
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
                System.out.println("Classifier ID: " + table.getClassifierId());
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    writer.close();
                    System.out.println("Setup.java: File closed successfully");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

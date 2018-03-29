import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Delete {

    private static VisualRecognition service;
    /*public static void main(String[] args) {

        service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);

        service.setApiKey("fb4201a556bd26be9ad01fef1c95bc23f3fb3aed");
        String directory = "C:/Users/Michael/Documents/Uni/MEng/Code/KinectAndWatson/";

        try {
            PrintWriter writer = new PrintWriter(directory + "save_files/classifierIDSave.txt");

        } catch (FileNotFoundException e) {
            System.out.println(
                    "Unable to open file '" + directory + "'");
        }
    }*/

    public Delete (VisualRecognition newService, String newDirectory) {
        service = newService;
        String directory = newDirectory;

        try {
            PrintWriter writer = new PrintWriter(directory + "save_files/classifierIDSave.txt");

        } catch (FileNotFoundException e) {
            System.out.println(
                    "Unable to open file '" + directory + "'");
        }
    }
}

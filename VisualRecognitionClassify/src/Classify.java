import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

import java.io.*;
import java.util.ArrayList;


public class Classify {
    private static VisualRecognition service;

    public static void main(String[] args) {

        String directory = "C:/Users/Michael/Documents/Uni/MEng/Code/";
        File positiveExampleOne = new File(directory + "Images/test1.jpg");
        File negativeExampleOne = new File(directory + "Images/test2.jpg");

        service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
        service.setApiKey("fb4201a556bd26be9ad01fef1c95bc23f3fb3aed");

        ArrayList<String> fileContents = readFile(directory + "save_files/classifierIDSave.txt");
        int fileContentsLength = fileContents.size();
        if(fileContentsLength > 0) {
            classifyImage(positiveExampleOne, fileContents.get(fileContentsLength-1));
        } else {
            System.out.println("No classifier ID present");
        }

    }

    private static ArrayList<String> readFile(String fileName) {
        String line;
        ArrayList<String> contents = new ArrayList<>();
        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                contents.add(line);
            }

            bufferedReader.close();
            return contents;
        } catch (FileNotFoundException e) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        } catch (IOException e) {
            System.out.println(
                    "Error reading file '" + fileName + "'");
        }
        return null;
    }

    private static void classifyImage(File inputFile, String classifierID) {
        try {
            ClassifyOptions options = new ClassifyOptions.Builder()
                    .imagesFile(inputFile)
                    .parameters("{\"classifier_ids\": [\"" + classifierID + "\"]}")
                    .build();
            ClassifiedImages result = service.classify(options).execute();
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

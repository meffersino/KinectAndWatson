import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class Initialise {
    private static VisualRecognition service;
    private final static int TIMEOUT = 5;
    public static void main(String[] args) {

        String directory = "C:/Users/Michael/Documents/Uni/MEng/Code/KinectAndWatson/Files/";
        String classifierDirectory = "classifiers/";

        service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
        service.setApiKey("3f40035a8c81ad5ea85d94b0eada74d08c9c70c3");

        System.out.println("Setup - starting");
        Setup setupClassifier = new Setup(service, directory);
        System.out.println("Setup - complete");

        try {
            TimeUnit.SECONDS.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Classify - starting");
        //Classify classifyImage = new Classify(service, directory, 0);
        System.out.println("Classify - complete");

        System.out.println("Delete - starting");
        //Delete deleteClassifier = new Delete(service, directory);
        System.out.println("Delete - complete");



        ArrayList<Integer> identifiers = new ArrayList<>();
        readIdentifiers(identifiers, directory);

        //ArrayList<String> classifierIdentifiers = new ArrayList<>();
        ArrayList<File> classifierIdentifiersFile = new ArrayList<>();
        File classifierDirectoryFile = new File(directory + classifierDirectory);
        String[] classifierIdentifiersArray = classifierDirectoryFile.list();
        Integer[] classifierIdentifiersArrayInteger = new Integer[classifierIdentifiersArray.length];

        for(int i = 0; i<classifierIdentifiersArray.length; i++) {

            classifierIdentifiersArrayInteger[i] = Integer.parseInt(classifierIdentifiersArray[i]);
            classifierIdentifiersFile.add(new File(directory + classifierDirectory + classifierIdentifiersArray[i]));

            if(!classifierIdentifiersFile.get(i).isDirectory()) {
                classifierIdentifiersFile.remove(i);
                System.out.println("Classifier " + i + "removed");
            } else if(identifiers.contains(classifierIdentifiersArrayInteger[i])) {
                //TODO add a classifier to the classify constructor
                System.out.println("Classifier " + i + " starting");
                Classify classifyID = new Classify(service, directory + classifierDirectory + classifierIdentifiersArray[i] + "/", i);
                System.out.println("Classifier " + i + " complete");
            } else {
                System.out.println(classifierIdentifiersArray[i] + " is a directory, but not present in the identifiers");

            }


        }
        for(Integer s: identifiers) {
            System.out.println(s);
        }





    }

    private static void readIdentifiers(ArrayList<Integer> identifiers, String directory) {
        String identifiersFile = "identifiers.csv";
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(directory + identifiersFile))) {

            while ((line = br.readLine()) != null) {
                String[] country = line.split(cvsSplitBy);
                for(int i = 0; i < country.length; i++) {
                    identifiers.add(Integer.parseInt(country[i]));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

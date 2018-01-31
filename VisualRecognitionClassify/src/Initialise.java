import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;

public class Initialise {
    private static VisualRecognition service;
    public static void main(String[] args) {

        service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
        service.setApiKey("fb4201a556bd26be9ad01fef1c95bc23f3fb3aed");
        Setup setupClassifier = new Setup(service);
        Classify classifyImage = new Classify(service);
        Delete deleteClassifier = new Delete(service);

    }
}

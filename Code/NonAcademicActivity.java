public class NonAcademicActivity extends Activity {
 public NonAcademicActivity(String activityName) {
        super(activityName);
    }

    @Override
    public void showDetails() {
        System.out.println(
            "Non-Academic Activity: " + activityName
        );
    }
}    
    


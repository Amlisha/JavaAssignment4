public class AcademicActivity extends Activity {
     public AcademicActivity(String activityName) {
        super(activityName);
    }

    @Override
    public void showDetails() {
        System.out.println(
            "Academic Activity: " + activityName
        );
    }
    
}

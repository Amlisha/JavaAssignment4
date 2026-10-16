public class ActivityValidator {

    public static void validateActivity(String activityName)
    throws InvalidActivityException{
        if(activityName == null || activityName.trim().isEmpty()){
            throw new InvalidActivityException("Activity name cannot be empty.");
        }
        System.out.println("Valid Activity:"+activityName);
    }
}

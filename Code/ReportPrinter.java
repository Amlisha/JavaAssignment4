public class ReportPrinter {
    //method overloading:same method name but different parameters
    public void printReport(String message){
        System.out.println(message);
    }

    public void printReport(String title,String message){
        System.out.println(title + ":" + message);
    }

    public void printReport(int reportNumber){
        System.out.println("Report Number:"+reportNumber);
    }
    
}

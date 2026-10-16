public class AccessChild extends AccessDemo{
    public void showInheritedData(){
        System.out.println("Public:"+publicData);
        System.out.println("Protected:"+protectedData);

        //private data cannot be accessed directly
    }
}
public class AccessDemo {
    public String publicData="Public Information";
    private String privateData="Confidential Information";
    protected String protectedData="Department Information";

    public void showInsideClass(){
        System.out.println("Public:"+publicData);
        System.out.println("Private:"+privateData);
        System.out.println("Protected:"+protectedData);
    }
    public String getPrivateData() {
        return privateData;
    }
    
}

public class Address implements Cloneable {
    String city;
    public Address(String city){
        this.city=city;
    }
    @Override 
    public Address clone(){
        try{
            return(Address) super.clone();
        }
        catch(CloneNotSupportedException e){
            throw new AssertionError(e);
        }
    }
    
}

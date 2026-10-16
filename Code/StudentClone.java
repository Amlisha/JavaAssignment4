public class StudentClone implements Cloneable {
    String name;
    Address address;

    public StudentClone(String name,Address address){
        this.name=name;
        this.address=address;
    }

    //shallow copy
    @Override
    public StudentClone clone(){
        try {
            return (StudentClone) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    // Deep copy
    public StudentClone deepClone() {
        return new StudentClone(name, address.clone());
    }
    
}

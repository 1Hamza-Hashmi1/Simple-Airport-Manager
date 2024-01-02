public class NonMember extends Passenger{
    
    public NonMember(String name, int age){
        super(name, age);
    }
    
    @Override
    public double applyDiscount(double p){
        if(this.age > 65){
            return p*0.9;
        }else{
            return p;
        }
    }
    
    @Override
    public String toString(){
        return String.format("NonMember --> Name:%s, Age:%d", this.name, this.age);
    }
}

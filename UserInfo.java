public class UserInfo {
    String name;
    int age;
    String email ;
    boolean isActive ;

    public UserInfo(String name, int age , String email , boolean isActive){
        this.name=  name;
        this.age  = age;
        this.email = email;
        this.isActive = isActive;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getEmail(){
        return email;
    }

    public boolean isActive(){
        return isActive;
    }

    public static void main(String[] args){

    }



}

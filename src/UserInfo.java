public class UserInfo {
    private String name = "nawaf";
    private int age = 11;
    private String email = "nawaf@gmail.com" ;
    boolean isActive = true;

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

    public void displayinfo(){
        System.out.println("student name" + " " + name );
        System.out.println("student age" + " " + age );
        System.out.println("student email" + " " +email );
        System.out.println("student is active" + " " + isActive );
    }

    public static void main(String[] args){

        UserInfo student1 = new UserInfo("nawaf" ,  22 , "nawaf@gmail.com" , false);
        UserInfo student2 = new UserInfo("nawal" , 22 , "nawal@gmail.com" , true);
        UserInfo student3 = new UserInfo("nouf" , 22 , "nouf@gmail.com" , true);

        student1.displayinfo();
        System.out.println("----------------");
        student2.displayinfo();
        System.out.println("----------------");
        student3.displayinfo();

    }



}

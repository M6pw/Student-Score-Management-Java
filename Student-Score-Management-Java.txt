package testclass;
import java.util.Scanner;
import java.util.InputMismatchException;
 
public class TestClass {
 
    public static void main(String[] args) {
       Student s1=new Student(123,"Ahmed", 5);
        s1.filScore();
       
        Scanner read=new Scanner(System.in);
          System.out.println("Enter index to get ots score: ");
          int y=read.nextInt();
            System.out.println(s1.getOneScore(y));
           
            s1.print();
       
       
       
    }
   
}
class Student{
    private int id;
    private String name;
    private int numCourse;
    private int [] score;
   
    public Student(int id, String name, int numCourse){
        this.id=id;
        this.name=name;
        this.numCourse=numCourse;
        score=new int[numCourse];
    }
   
    public void filScore(){
        for(int i=0; i<score.length;i++){
            Scanner read=new Scanner(System.in);
            System.out.println("Enter Score: ");
            try{
                score[i]=read.nextInt();
            }
            catch(InputMismatchException x){
                  System.out.println(x);
                  read.nextLine();
            }
               
           
        }
    }
    public int getOneScore(int inx){
      
       try{
           return score[inx];
       }
       catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException : "+inx);
                    return -1;
           
       }
       
    }
    public void print(){
        System.out.println("name: "+name);
        System.out.println("id: "+id);
        System.out.println("number of course: "+numCourse);
           for(int m: score){
                 System.out.print(m+"     ");
           }
             System.out.println(" ");
    }
}
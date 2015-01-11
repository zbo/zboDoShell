package main.java;

/**
 * Created by twer on 15-1-11.
 */
public class FinallyTest2 {
    public static int fun1(){
        try{
            System.out.println("try1");
            throw new RuntimeException("Exception1");
        }catch(Exception e){
            System.out.println("catch1");
            return 1;
        }
        finally{
            System.out.println("finally1");
            try{
                throw new RuntimeException("finally exception");
            }catch(NullPointerException e){
                return 3;
            }finally {
                System.out.println("finally2");;
            }
        }
    }

    public static void main(String[] args){
        try{
            System.out.println("fun1:" + fun1());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

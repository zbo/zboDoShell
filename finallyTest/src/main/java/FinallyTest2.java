package main.java;

/**
 * Created by twer on 15-1-11.
 */
public class FinallyTest2 {
    public static int fun1(){
        try{
            System.out.println("try1"); //1.打印出try1
            throw new RuntimeException("Exception1"); //把Exception1放到返回栈顶
        }catch(Exception e){
            System.out.println("catch1"); //Exception1被接住
            return 1;//把return 1 放到返回栈顶，这时候Exception1被替换了
        }
        finally{
            System.out.println("finally1"); //返回之前，返回之前执行finally，打印finally1
            try{
                //throw new RuntimeException("finally exception");//抛出finally exception， 放到栈顶，把return 1替换了
            }catch(NullPointerException e){
                return 3;//这里没有匹配，所以没执行到
            }finally {
                System.out.println("finally2");//打印出finally2
            }
        }
    }

    public static void main(String[] args){
        try{
            System.out.println("fun1:" + fun1());//最后得到栈顶上的东西，就是finally exception
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

package main.java;

/**
 * Created by twer on 15-1-11.
 */
public class FinallyTest {
    //说明在try里return之前，finally被调用到了
    static int f1() {
        try {
            return 1;
        } finally {
            System.out.print("f1");
        }
    }
    //说明在catch里return之前，finally被调用了
    static int f2() {
        try {
            throw new Exception("try error");
        } catch (Exception e) {
            return 2;
        } finally {
            System.out.print("f2");
        }
    }
    //try里抛出漏网的exception，先执行finally，然后抛出Exception，不会return
    static int f3() {
        try {
            throw new RuntimeException("try error");
        } catch (ArithmeticException e) {
            return 3;
        } finally {
            System.out.print("f3");
        }
    }
    //catch里抛出漏网的exception，先执行finally，然后抛出Exception
    static int f4() {
        try {
            throw new Exception("try error");
        } catch (Exception e) {
            throw new RuntimeException("catch error");
        } finally {
            System.out.print("f4");
        }
    }
    //finally里return，把catch抛出的exception忽略了
    static int f5() {
        try {
            throw new Exception("try error");
        } catch (Exception e) {
            throw new RuntimeException("catch error");
        } finally {
            System.out.print("f5");
            return 5;
        }
    }
    //finally里抛出exception，把catch抛出的exception忽略了
    static int f6() {
        try {
            throw new Exception("try error");
        } catch (Exception e) {
            throw new RuntimeException("catch error");
        } finally {
            System.out.print("f6");
            throw new RuntimeException("finally error");
        }
    }


    public static void main(String[] args) {
        System.out.println("start test try catch finally");
        System.out.println(" : " + f1());
        try {
            System.out.println(" : " + f2());
        } catch (Exception e) {
            System.out.println(" : " + e.getMessage());
        }
        try {
            System.out.println(" : " + f3());
        } catch (Exception e) {
            System.out.println(" : " + e.getMessage());
        }
        try {
            System.out.println(" : " + f4());
        } catch (Exception e) {
            System.out.println(" : " + e.getMessage());
        }
        try {
            System.out.println(" : " + f5());
        } catch (Exception e) {
            System.out.println(" : " + e.getMessage());
        }
        try {
            System.out.println(" : " + f6());
        } catch (Exception e) {
            System.out.println(" : " + e.getMessage());
        }
    }
}

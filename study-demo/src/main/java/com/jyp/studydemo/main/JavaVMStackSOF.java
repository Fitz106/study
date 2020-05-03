package com.jyp.studydemo.main;

/**
 * @author ：jiyuepeng
 * @date ：Created in 2020/5/1 17:24
 * @description：虚拟机栈和本地方法栈OOM测试   -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main (String[] args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}

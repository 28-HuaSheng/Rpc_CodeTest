package com.test;

import com.sun.tools.javac.jvm.Code;

import java.util.HashMap;
import java.util.Map;

public class CodeTest {
    public long attr;
    public CodeTest() {
    }
    public CodeTest(long attr){
        this.attr=attr;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeTest codeTest = (CodeTest) o;
        return attr == codeTest.attr;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "CodeTest{" +
                "attr=" + attr +
                '}';
    }

    public static void main(String[] args) {
        CodeTest codeTest = new CodeTest(13l);
        Code2 code2 = new Code2(999l);
        Code2 code3 = new Code2(999l);
        Map<Object,Long> map = new HashMap<>();
        map.put(codeTest,123l);
        map.put(code2,1234l);
        map.putIfAbsent(code3,123456l);
        System.out.println(map.get(code2));



    }

}
class Code2{
    public long age;
    public Code2(){

    }
    public Code2(long age){
        this.age = age;
    }
    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Code2){
            return ((Code2) o).age == this.age;
        }
        return false;
    }
}


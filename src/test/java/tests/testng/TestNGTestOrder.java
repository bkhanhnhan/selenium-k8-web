package tests.testng;

import org.testng.annotations.Test;

public class TestNGTestOrder {

    @Test
    public void test02(){
        System.out.println("Test 01");
    }
    @Test
    public void test02(){
        System.out.println("Test 02");
    }
}

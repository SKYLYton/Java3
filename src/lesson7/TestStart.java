package lesson7;

public class TestStart {
    @Test(priority = 3)
    static void startTestMethod1(){
        System.out.println("3");
    }

    @Test(priority = 6)
    static void startTestMethod2(){
        System.out.println("6");

    }

    @Test
    static void startTestMethod3(){
        System.out.println("default");

    }

    @BeforeSuite
    static void startTestMethodB(){
        System.out.println("B");

    }

    @AfterSuite
    static void startTestMethodA(){
        System.out.println("A");

    }

}

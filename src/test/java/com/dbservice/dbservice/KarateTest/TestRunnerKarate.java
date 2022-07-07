package com.dbservice.dbservice.KarateTest;







import com.intuit.karate.junit5.Karate;



public class TestRunnerKarate {

    @Karate.Test
    Karate testSample(){
        return Karate.run("GetApiTest").relativeTo(getClass());
    }
    @Karate.Test
    Karate testSampleTest(){
        return Karate.run("simple").relativeTo(getClass());
    }
}

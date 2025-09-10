package com.example.pierwszetestywmobilce;

import static com.example.pierwszetestywmobilce.Liczby.nwd;

import org.junit.Test;
import static org.junit.Assert.*;

public class SzybkieUnitTest {
    @Test
    public void test_NWD_correct(){
        assertEquals(5, nwd(10, 5));
    }

    @Test
    public void test_NWD_incorrect(){
        assertNotEquals(6, nwd(10, 5));
    }
}

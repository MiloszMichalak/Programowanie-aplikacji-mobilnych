package com.example.pierwszetestywmobilce;

public class Liczby {
    public static int nwd(int a, int b){
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
}

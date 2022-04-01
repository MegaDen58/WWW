package com.company;
import java.math.BigInteger;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p;
        int g;
        int x;
        int keyOfSession;
        BigInteger pf;
        BigInteger gf;
        BigInteger xf;
        BigInteger keyOfSessionf;

        // Generation of key

        while (true){
            System.out.print("Введите коэффициент P (простое число): ");
            p = in.nextInt();
            if(checkForCorrectness(p)){
                pf = BigInteger.valueOf(p);
                break;
            }
        }


        while(true){
            System.out.print("Введите коэффициент g (диапазон от 1 до 15): ");
            g = in.nextInt();
            if(g >= 1 & g <= 15){
                break;
            }
        }

        while(true) {
            System.out.print("Введите коэффициент x (1 < x < P): ");
            x = in.nextInt();
            if (x > 1 & x < p) {
                break;
            }
        }

        // Key encryption

        System.out.print("Введите сообщение: ");
        BigInteger M = in.nextBigInteger();

        while(true) {
            System.out.print("Введите ключ сессии (1 < ключ < P - 1): ");
            keyOfSession = in.nextInt();
            if (keyOfSession > 1 & keyOfSession < p - 1) {
                break;
            }
        }




        int y = (int)Math.pow(g, x) % p;
        System.out.printf("y = %d\n", y);
        int a = (int)Math.pow(g, keyOfSession) % p;
        System.out.printf("a = %d\n", a);
        BigInteger bPow = BigInteger.valueOf((int)Math.pow(y,keyOfSession));
        BigInteger bMulty = M.multiply(bPow);
        BigInteger b = bMulty.mod(pf);
        System.out.printf("b = %d\n", b);
        System.out.printf("Шифр (%d, %d)\n", a, b);

        // Decryption

        BigInteger pow = BigInteger.valueOf(((int)Math.pow(a, p - 1 - x)));
        BigInteger result = b.multiply(pow);
        BigInteger result2 = result.mod(pf);
        System.out.print(result2);
    }

    public static boolean checkForCorrectness(int p){

        for (int i = 2; i <= (p / 2) + 1; i++){
            if(p % i == 0){
                return false;
            }
        }
        return true;
    }
}

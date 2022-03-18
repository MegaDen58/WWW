package com.company;
import javax.xml.validation.Schema;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = 0;
        int g = 0;
        int x = 0;
        int keyOfSession = 0;

        // Generation of key

        while (true){
            System.out.print("Введите коэффициент P (простое число): ");
            p = in.nextInt();
            if(checkForCorrectness(p)){
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
        int M = in.nextInt();

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
        int b = ((int)Math.pow(y,keyOfSession) * M) % p;
        System.out.printf("b = %d\n", b);
        System.out.printf("Шифр (%d, %d)\n", a, b);

        // Decryption

        System.out.print((b * (int) Math.pow(a, p - 1 - x)) % p);
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

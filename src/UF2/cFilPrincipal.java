package UF2;

import UF2.cFil;
import java.util.Scanner;

public class cFilPrincipal {

    public static void main(String[] pArguments) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Cuants processos fills vols iniciar?");
        int pFills = scan.nextInt();

        while (pFills >= 15) {
            System.out.println("Que no sigui superior o igual a 15!");
            System.out.println("Cuants processos fills vols iniciar?");
            pFills = scan.nextInt();
        }

        Thread[] fills = new Thread[pFills];

        System.out.println("Fil principal iniciat.");

        int t = 0;

        for (int i = 0; i < pFills; i++) {
            cFil vObjecteFil = new cFil("#" + (i+1));
            t += 100;
            vObjecteFil.sTemporitzacio(t);
            // alternativa: innecessari
            fills[i] = new Thread(vObjecteFil);
            fills[i].start();
            System.out.println("Fil secundari " + (i+1) + " iniciat.");
        }


        System.out.println("Iniciant execució procés principal");

        try {
            for (int vComptador = 0; vComptador < 10; vComptador++) {

                Thread.sleep(500);

                System.out.println("Despertant aturada "
                        + vComptador
                        + " procés principal");
            }

        } catch (InterruptedException pExcepcio) {
            System.out.println("Interrompent execució procés principal");
        }

        System.out.println("Acabant execució procés principal");
    }
}

package UF2;

import UF2.cFil;

public class cFilPrincipal {

    public static void main(String[] pArguments) throws InterruptedException {

        System.out.println("Fil principal iniciat.");
        System.out.println("Fil secundari iniciat.");

        cFil vObjecteFil = new cFil("#1");
        vObjecteFil.sTemporitzacio(1000);

        // alternativa: innecessari
        Thread vFil = new Thread(vObjecteFil);

        // alternativa: vObjecteFil
        vFil.start();
        vFil.join();
        // ho podriem fer tantejant els milisegons amb el sleep del procés principal (pare),
        // pero apart de que no estaria sincronitzat i imprecis, utilitzem join per basicament
        // dir al procés pare que s'ha de esperar al procés fill a que acabi, li podem passar per parametre milisegons de espera també.

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

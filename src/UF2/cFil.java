package UF2;

/* la classe Cfil compta amb diferents funcionalitats.
 *  - Instanciar objectes a partir dels que es puguin crear fils d'execució paral·lela.
 *  - La classe compta amb un constructor que accepta com a paràmetre un nom pel procès creat.
 *  - També compta amb un getter on realitza una consulta del nombre del procès creat.
 *  - També compta amb un setter que modifica l'atribut de temporització de la classe.
 *  - El métode run() sobrecàrrega la funció que representa el procediment main.
 *
 *  Les dues primeres tasques de la pràctica es treballen en aquesta classe.
 *  1.1 Necessàriament modificar la temporització del procès fill, on acabi la seva execució
 *      bastant més abans del seu procès pare. Mitjançant un métode concret.
 *
 *  1.2 Tornar a modificar la temporització del procès fill, però aquest cop es vol finalitzar
 *      la seva execució posteriorment a la del pare. Mitjançant un métode concret.      */

// alternativa: extends Thread
public class cFil implements Runnable {

    String aNomFil;
    int aTemporitzacio;

    public cFil(String pNomFil) {
        aTemporitzacio = 500;
        aNomFil = pNomFil;
    }

    // getter
    public String gNomFil() {
        return aNomFil;
    }

    // setter
    public void sTemporitzacio(int pTemporitzacio) {
        aTemporitzacio = pTemporitzacio;
    }

    @Override
    public void run() {
        System.out.println("Iniciant execució procés " + aNomFil);

        try {
            for (int vComptador = 0; vComptador < 10; vComptador++) {
                Thread.sleep(aTemporitzacio);
                System.out.println("Despertant aturada " + vComptador + " procés " + aNomFil);
            }
        } catch (InterruptedException pExcepcio) {
            System.out.println("Interrompent execució procés " + aNomFil);
        }

        System.out.println("Acabant execució procés " + aNomFil);
    }
}
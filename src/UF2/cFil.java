package UF2;

// alternativa: extends Thread
public class cFil implements Runnable {

    String aNomFil;
    int aTemporitzacio;

    public cFil(String pNomFil) {
        aTemporitzacio = 100;
        aNomFil = pNomFil;
    }

    public String gNomFil() {
        return aNomFil;
    }

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
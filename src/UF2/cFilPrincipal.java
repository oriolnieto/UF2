package UF2;

import UF2.cFil; // importada la classe Cfil

/* És la classe principal del projecte. Crea i executa un procés fill. Aquesta classe treballa
   les dues pràctiques posteriors de l'activitat. Aqui existeixen dos fils d'execució en paral·lel,
   el procediment principal/main i el procediment run() de la classe Cfil. És per això que és necessari
   importar com a llibreria la classe Cfil per poder executar aquest mètode.

   1.3 Tot i que no és una norma obligatòria, és recomanable que el procès pare sempre acabi després
       de qualsevol dels seus processos fills. La classe principal s'ha de modificar per investigar quins
       métodes proporciona la classe Thread.

   1.4 Necessariàment modificar la classe principal de manera que aquesta inicï l'execució de tants processos
       fills com l'usuari indiqui. L'usuari indica quants mitjançant un paràmetre del procediment main o per consola.

   Amb el métode corresponent de la classe Cfil per a que cada procès fill iniciat per el procés pare tingui una temporització
   diferent. Primerament el procès fill, el més petit, fins a l'ultim amb major temporització successivament.
   El procès pare no finalitza fins que tots el processos fills no hagin acabat la seva execució.
   Per no sobrecarregar s'ha d'indica un limit per a que l'usuari no pugui introduir un nombre de processos fills superior aquest i
   no majoritàriament gran. 
* */

public class cFilPrincipal {

    public static void main(String[] pArguments) {

        System.out.println("Fil principal iniciat.");
        System.out.println("Fil secundari iniciat.");

        cFil vObjecteFil = new cFil("#1");
        vObjecteFil.sTemporitzacio(100);
        /* la variable de l'objecte fil de la classe es modifica el setter de temporització de 500 a 1000
           Aquesta modificació permet que la execució del fill finalitzi abans que la del pare
        */

        // alternativa: innecessari
        Thread vFil = new Thread(vObjecteFil);

        // alternativa: vObjecteFil
        vFil.start();

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

package com.mycompany.metodoplantilla.app;

import com.mycompany.metodoplantilla.core.DataMiner;
import com.mycompany.metodoplantilla.miners.CSVDataMiner;
import com.mycompany.metodoplantilla.miners.DocDataMiner;
import com.mycompany.metodoplantilla.miners.PDFDataMiner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENU DATA MINER ===");
            System.out.println("1. Procesar CSV");
            System.out.println("2. Procesar DOC");
            System.out.println("3. Procesar PDF");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Ingrese la ruta del archivo: "+"(Favor eliminar comillas.)");
            String ruta = sc.nextLine().trim();

            DataMiner miner = null;

            switch (opcion) {
                case 1:
                    miner = new CSVDataMiner();
                    break;
                case 2:
                    miner = new DocDataMiner();
                    break;
                case 3:
                    miner = new PDFDataMiner();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    continue;
                default:
                    System.out.println("Opcion invalida");
                    continue;
            }

            try {
                miner.mine(ruta);
            } catch (Exception e) {
                System.out.println("Error procesando archivo: " + e.getMessage());
            }

        } while (opcion != 0);

        sc.close();
    }
}
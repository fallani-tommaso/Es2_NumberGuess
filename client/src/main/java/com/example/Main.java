package com.example;

import java.io.*;
import java.net.*;


public class Main {
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 6789);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader inServ = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String stringaServer;
            int n = 0;
            do {
                n++;
                System.out.println("Inserisci un numero da indovinare");
                String st = in.readLine();
                out.writeBytes(st + '\n');
                stringaServer = inServ.readLine();
                if (stringaServer.equals("1"))
                {
                    System.out.println("Troppo alto");
                }
                if (stringaServer.equals("2"))
                {
                    System.out.println("Troppo basso");
                }
                if(stringaServer.equals("3"))
                {
                    System.out.println("Devi inserire un numero compreso tra 1 e 100");
                }
            } while (Integer.parseInt(stringaServer)!= 4);
            System.out.println("Numero indovinato!");
            System.out.println("HAI INDOVINATO in " + n + " tentativi!");
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore");
            System.exit(1);
        }
    }
}

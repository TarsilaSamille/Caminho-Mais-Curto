package com.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App {

  public static void main(String[] args) throws NumberFormatException, IOException {
    readMapas();
  }

  public static void readMapas() throws NumberFormatException, IOException {
    File file = new File("demo/src/mapas/mapas.txt");
    BufferedReader bufRdr = new BufferedReader(new FileReader(file));
    String line = null;
    while ((line = bufRdr.readLine()) != null) {
      readMapa(line);
    }
  }

  public static void readMapa(String fn) throws NumberFormatException, IOException {
    String filename = "demo/src/mapas/" + fn;
    Dijkstra d = new Dijkstra();

    System.out.print(filename);

    readDimacs(filename, d);

    long tempoInicial = System.currentTimeMillis();
    d.reconstructPath(1, d.getN() - 1);
    long tempoFinal = System.currentTimeMillis();

    System.out.println(" " + (tempoFinal - tempoInicial) / 1000d + "  ms ");

  }

  /**
   * @throws NumberFormatException
   * @throws IOException
   */
  public static void readDimacs(String filename, Dijkstra dijkstra) throws NumberFormatException, IOException {
    File file = new File(filename);
    BufferedReader bufRdr = new BufferedReader(new FileReader(file));
    String line = null;
    while ((line = bufRdr.readLine()) != null) {
      String[] str = line.split(" ");
      if (str[0].equals("p")) {
        dijkstra.setN(toInt(str[2]) + 1);
      }
      if (str[0].equals("a")) {
        dijkstra.addEdge(toInt(str[1]), toInt(str[2]), toInt(str[3]));
      }
    }
  }

  private static int toInt(String str) {
    return Integer.parseInt(str);

  }

}

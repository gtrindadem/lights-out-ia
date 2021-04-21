package dao;

import entity.Tabuleiro;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputInstance {

    public static Tabuleiro getInstance(String file) {

        Tabuleiro tabuleiro = null;

        InputStream is;
        InputStreamReader isr;
        BufferedReader br;

        try {
            is = new FileInputStream(file);
            isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            String line = br.readLine();
            Tabuleiro.setN(Integer.parseInt(line.trim()));
            int[][] luzes = new int[Tabuleiro.N][Tabuleiro.N];
            for(int i=0; i<Tabuleiro.N; i++) {
                line = br.readLine();
                String[] valores = line.split(" ");
                for(int j=0; j<Tabuleiro.N; j++) {
                    luzes[i][j] = Integer.parseInt(valores[j]);
                }
            }
            tabuleiro = new Tabuleiro(luzes);
        }catch(IOException e) {
            e.printStackTrace();
        }

        return tabuleiro;

    }

}

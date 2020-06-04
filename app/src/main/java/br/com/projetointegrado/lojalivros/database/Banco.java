package br.com.projetointegrado.lojalivros.database;

import java.io.Serializable;

public class Banco implements Serializable {

    private static String banco = "db_livraria.db";
    private static String tabelaUsuario = "usuario";

    public static String banco(){
        return banco;
    }

    public static String criaTabelaUsuario(){
        return "CREATE TABLE IF NOT EXISTS " + tabelaUsuario() + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR NOT NULL, " +
                "email VARCHAR NOT NULL, " +
                "senha VARCHAR NOT NULL" +
                ");";
    }

    public static String tabelaUsuario(){
        return tabelaUsuario;
    }

}

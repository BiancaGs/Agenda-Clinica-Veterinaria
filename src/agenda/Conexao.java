/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pietr
 */
public class Conexao {
    
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/agenda_clinica";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";
    
    // Construtor privado para que ninguém possa instanciar a classe
    private Conexao() {
        
    }
    
    // Variável static privada para a instância
    private static Connection instanceConnection;
    
    // Método static para capturar a conexão
    public static Connection getConnection() {
        
        if (instanceConnection == null) {
            try {
                Class.forName(DRIVER_CLASS);                                                // carrega o driver
                instanceConnection = DriverManager.getConnection(URL_MYSQL, USER, PASS);    // carrega a instancia
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
            
        }
        
        // Retorna a instância
        return instanceConnection;
        
    }
    
}

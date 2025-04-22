package puc.poobd.atv22042025;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {
    private static volatile BancoDados instance;
    private final Connection connection;

    private BancoDados() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:database");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }

    public static BancoDados getInstance() {
        if (instance == null) {
            synchronized (BancoDados.class) {
                if (instance == null) {
                    instance = new BancoDados();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

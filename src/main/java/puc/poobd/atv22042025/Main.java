package puc.poobd.atv22042025;

import javafx.application.Application;
import puc.poobd.atv22042025.dto.SolicitacaoEquipamentoDTO;
import puc.poobd.atv22042025.view.MainView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        SolicitacaoEquipamentoDTO dto = new SolicitacaoEquipamentoDTO();
        dto.criar();
        Application.launch(MainView.class);
    }
}

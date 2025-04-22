package puc.poobd.atv22042025.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import puc.poobd.atv22042025.dto.SolicitacaoEquipamentoDTO;
import puc.poobd.atv22042025.model.SolicitacaoEquipamento;

import java.sql.SQLException;
import java.util.List;

public class MainController {
    @FXML
    private TextField nomeColaborador;

    @FXML
    private TextField equipamento;

    @FXML
    private DatePicker dataSolicitacao;

    @FXML
    private TableView<SolicitacaoEquipamentoDTO> tabela;

    @FXML
    private TableColumn<SolicitacaoEquipamentoDTO, Long> colunaId;
    @FXML
    private TableColumn<SolicitacaoEquipamentoDTO, String> colunaNomeColaborador;
    @FXML
    private TableColumn<SolicitacaoEquipamentoDTO, String> colunaEquipamento;
    @FXML
    private TableColumn<SolicitacaoEquipamentoDTO, String> colunaDataSolicitacao;

    @FXML
    public void initialize() {
        // Vincular os atributos da classe às colunas
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNomeColaborador.setCellValueFactory(new PropertyValueFactory<>("nomeColaborador"));
        colunaEquipamento.setCellValueFactory(new PropertyValueFactory<>("equipamento"));
        colunaDataSolicitacao.setCellValueFactory(new PropertyValueFactory<>("dataSolicitacao"));
    }

    @FXML
    protected void solicitarOnAction(ActionEvent e) throws SQLException {
        SolicitacaoEquipamentoDTO dto = new SolicitacaoEquipamentoDTO();
        SolicitacaoEquipamento se = new SolicitacaoEquipamento();
        se.setNomeColaborador(nomeColaborador.getText());
        se.setEquipamento(equipamento.getText());
        se.setDataSolicitacao(dataSolicitacao.getValue().toString());

        System.out.println(se);

        dto.inserir(se);

        new Alert(Alert.AlertType.INFORMATION, "Solicitação inserida com sucesso.").showAndWait();
    }

    @FXML
    protected void listarOnAction(ActionEvent e) throws SQLException {
        SolicitacaoEquipamentoDTO dto = new SolicitacaoEquipamentoDTO();
        List<SolicitacaoEquipamentoDTO> lista = dto.listar();
        tabela.setItems(
                FXCollections.observableList(
                        lista
                )
        );
    }
}
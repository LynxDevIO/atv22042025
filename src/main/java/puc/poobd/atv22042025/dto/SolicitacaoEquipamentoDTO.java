package puc.poobd.atv22042025.dto;

import puc.poobd.atv22042025.model.SolicitacaoEquipamento;
import puc.poobd.atv22042025.db.BancoDados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoEquipamentoDTO {
    Connection connection = BancoDados.getInstance().getConnection();

    private Long id;
    private String nomeColaborador;
    private String equipamento;
    private String dataSolicitacao;

    public SolicitacaoEquipamentoDTO() throws SQLException {
    }

    /**
     * cria a tabela
     */
    public void criar() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS solicitacao (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome_colaborador TEXT, " +
                "equipamento TEXT, " +
                "data_solicitacao TEXT)";
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
    }

    /**
     * Inserir SolicitacaoEquipamento
     * @param se
     */
    public void inserir(SolicitacaoEquipamento se) throws SQLException {
        String sql = "INSERT INTO solicitacao (nome_colaborador, equipamento, data_solicitacao) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, se.getNomeColaborador());
            ps.setString(2, se.getEquipamento());
            ps.setString(3, se.getDataSolicitacao());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir os dados: " + e.getMessage(), e);
        }
    }

    /**
     * Lista os SolicitacaoEquipamento
     * @return
     * @throws SQLException
     */
    public List<SolicitacaoEquipamentoDTO> listar() throws SQLException {
        List<SolicitacaoEquipamentoDTO> l = new ArrayList<>();
        String sql = "SELECT * FROM SOLICITACAO";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            SolicitacaoEquipamentoDTO se = new SolicitacaoEquipamentoDTO();

            se.setId(rs.getLong("id"));
            se.setNomeColaborador(rs.getString("nome_colaborador"));
            se.setEquipamento(rs.getString("equipamento"));
            se.setDataSolicitacao(rs.getString("data_solicitacao"));

            l.add(se);
        }

        return l;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}

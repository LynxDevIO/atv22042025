package puc.poobd.atv22042025.model;

public class SolicitacaoEquipamento {
    private Long id;
    private String nomeColaborador;
    private String equipamento;
    private String dataSolicitacao;

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

    @Override
    public String toString() {
        return "SolicitacaoEquipamento{" +
                "nomeColaborador='" + nomeColaborador + '\'' +
                ", equipamento='" + equipamento + '\'' +
                ", dataSolicitacao='" + dataSolicitacao + '\'' +
                '}';
    }
}

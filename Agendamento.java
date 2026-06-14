package barbeariatrabalho;

public class Agendamento{
    private Cliente cliente;
    private Servicos servico;
    private String dia;
    private String horario;
    
    public Agendamento(Cliente cliente, Servicos servico, String dia, String horario) {
        this.cliente = cliente;
        this.servico = servico;
        this.dia = dia;
        this.horario = horario;
    }
    
    public String mostrarAgendamento() {
        return "Cliente: " + cliente.getNome()
                +" | Serviços: " + servico.getNome()
                +" | Dia: " + dia
                +" | Horário: " + horario 
                +" | Valor: R$" + servico.getPreco();
    }
    
    public Servicos getServicos() {
        return servico;
    }
}
package bean;

import java.sql.Date;

public class Viagem {
	private int codigo;
	private Destino destino;
	private Transporte transporte;
	private double distancia;
	private double duracao;
	private Date partida;
	private Date chegada;
	private double valor;
	
	public Viagem(int codigo, Destino destino, Transporte transporte, double distancia,
			double duracao, Date partida, Date chegada, double valor) {
		super();
		this.codigo = codigo;
		this.destino = destino;
		this.transporte = transporte;
		this.distancia = distancia;
		this.duracao = duracao;
		this.partida = partida;
		this.chegada = chegada;
		this.valor = valor;
	}

	public Viagem() {
    }

    public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public Date getPartida() {
		return partida;
	}

	public void setPartida(Date partida) {
		this.partida = partida;
	}

	public Date getChegada() {
		return chegada;
	}

	public void setChegada(Date chegada) {
		this.chegada = chegada;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Viagem [codigo=" + codigo + ", destino=" + destino + ", transporte=" + transporte + ", distancia="
				+ distancia + ", duracao=" + duracao + ", partida=" + partida + ", chegada=" + chegada + ", valor="
				+ valor + "]";
	}

}

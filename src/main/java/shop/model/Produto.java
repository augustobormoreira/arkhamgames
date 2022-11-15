package shop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    private String nome;

    @NotNull
    @Size(max = 1000)
    private String descricao;

    @NotNull
    @Size(max = 50)
    private String marca;

    @NotNull
    @URL
    private String img;

    @NotNull
    private int preco;

    @NotNull
    private String categoria;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "produto_pedido", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "pedido_id"))
  
    @JsonIgnoreProperties({"pedidos", "listaDeDesejos", "compras", "meuPedido"})
    private List<Cliente> pedidos = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "produto_lista",joinColumns = @JoinColumn(name = "produto_id"),inverseJoinColumns = @JoinColumn(name = "lista_id"))
    @JsonIgnoreProperties({"pedidos", "listaDeDesejos"})
    private List<Cliente> listaDesejos = new ArrayList<>();
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "produto_compra",joinColumns = @JoinColumn(name = "produto_id"),inverseJoinColumns = @JoinColumn(name = "compra_id"))
	
    @JsonIgnoreProperties({"meuPedido"})
	private List<Compras> compra = new ArrayList<>();


    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

    public String getCategoria() {
		return categoria;
	}
    
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

    public List<Cliente> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Cliente> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Cliente> getListaDesejos() {
		return listaDesejos;
	}

	public void setListaDesejos(List<Cliente> listaDesejos) {
		this.listaDesejos = listaDesejos;
	}



}

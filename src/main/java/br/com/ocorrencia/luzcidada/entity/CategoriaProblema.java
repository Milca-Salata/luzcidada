package br.com.ocorrencia.luzcidada.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="categorias_problema")
public class CategoriaProblema {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false,unique=true,length=80) private String nome;
 @Column(length=255) private String descricao;
 @Column(nullable=false) private boolean ativa=true;

 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
 public String getDescricao(){return descricao;} public void setDescricao(String descricao){this.descricao=descricao;}
 public boolean isAtiva(){return ativa;} public void setAtiva(boolean ativa){this.ativa=ativa;}
}

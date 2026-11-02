package br.com.ocorrencia.luzcidada.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name="usuarios")
public class Usuario {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false,length=100) private String nome;
 @Email @NotBlank @Column(nullable=false,unique=true,length=150) private String email;
 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) @NotBlank @NotBlank @Column(nullable=false,name="senha_hash") private String senhaHash;
 @Column(length=20) private String telefone;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private TipoUsuario tipoUsuario=TipoUsuario.MORADOR;
 @Column(nullable=false) private boolean ativo=true;
 @Column(nullable=false,updatable=false) private LocalDateTime dataCadastro;
 @PrePersist void prePersist(){ if(dataCadastro==null)dataCadastro=LocalDateTime.now(); }
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
 public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
 public String getSenhaHash(){return senhaHash;} public void setSenhaHash(String senhaHash){this.senhaHash=senhaHash;}
 public String getTelefone(){return telefone;} public void setTelefone(String telefone){this.telefone=telefone;}
 public TipoUsuario getTipoUsuario(){return tipoUsuario;} public void setTipoUsuario(TipoUsuario tipoUsuario){this.tipoUsuario=tipoUsuario;}
 public boolean isAtivo(){return ativo;} public void setAtivo(boolean ativo){this.ativo=ativo;}
 public LocalDateTime getDataCadastro(){return dataCadastro;}
}

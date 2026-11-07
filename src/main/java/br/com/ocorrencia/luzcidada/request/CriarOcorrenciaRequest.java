package br.com.ocorrencia.luzcidada.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
public record CriarOcorrenciaRequest(@NotNull Long moradorId, @NotBlank String titulo,
 @NotBlank String descricao, String endereco, String bairro, BigDecimal latitude,
 BigDecimal longitude, Long categoriaId) {}

package br.com.ocorrencia.luzcidada.request;
import br.com.ocorrencia.luzcidada.entity.StatusOcorrencia;
import jakarta.validation.constraints.NotNull;
public record AtualizarStatusRequest(@NotNull Long usuarioId, @NotNull StatusOcorrencia status, String comentario) {}

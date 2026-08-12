package com.luiz.transacao_api.services;

import com.luiz.transacao_api.dto.TransacaoRequestDTO;
import com.luiz.transacao_api.exceptions.UnprocessableContent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private static final Logger log = LoggerFactory.getLogger(TransacaoService.class);
    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void criarTransacao(TransacaoRequestDTO transacao) {

        log.info("Processo de transação iniciado");

        if(transacao.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora da transação maiores que data e hora atual");
            throw new UnprocessableContent("Data e hora da transação maiores que data e hora atual");
        }

        if(transacao.valor() < 0) {
            log.error("valor da transação negativo");
            throw new UnprocessableContent("valor da transação negativo");
        }

        listaTransacoes.add(transacao);
    }
}

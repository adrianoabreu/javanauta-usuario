package com.javanauta.usuario.business;

import com.javanauta.usuario.infrastructure.clients.ViaCepClient;
import com.javanauta.usuario.infrastructure.clients.ViaCepDTO;
import com.javanauta.usuario.infrastructure.exceptions.IllegalArgumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    private final ViaCepClient client;

    public ViaCepDTO buscarDadosEndereco(String cep){
        return client.buscaDadosEndereco(processarCep(cep));
    }

    private String processarCep(String cep){
        String cepFormatado = cep.replace(" ", "")
                .replace("-","");

//      Se o Cep não for numerico ou o tamanho diferente de 8
//      if(!cepFormatado.matches("[0-9]")  || !Objects.equals(cepFormatado.length(),8)){
        if(!cepFormatado.matches("\\d+") || !Objects.equals(cepFormatado.length(),8)) {
            throw new IllegalArgumentException("O cep contém caracteres inválidos, favor verificar");
        }
        return cepFormatado;
    }
}

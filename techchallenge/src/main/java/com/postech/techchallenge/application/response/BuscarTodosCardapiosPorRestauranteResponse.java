package com.postech.techchallenge.application.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BuscarTodosCardapiosPorRestauranteResponse {
    private List<BuscarCardapioResponse> listaCardapios = new ArrayList<>();

}

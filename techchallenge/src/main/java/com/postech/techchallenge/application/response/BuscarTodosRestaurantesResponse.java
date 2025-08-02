package com.postech.techchallenge.application.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuscarTodosRestaurantesResponse {
    private List<BuscarRestauranteResponse> listaRestaurantes = new ArrayList<>();
}

package Interfaces;

import Exception.ValorSuperiorException;

public interface iPagamento {
    double CalcularCustoAgendamento(int h);
    double PagarParcialmente (double v,double v2) throws ValorSuperiorException;
}

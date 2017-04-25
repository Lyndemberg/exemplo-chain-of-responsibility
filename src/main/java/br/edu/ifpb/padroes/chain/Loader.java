package br.edu.ifpb.padroes.chain;

import br.edu.ifpb.padroes.chain.metodos.CartaoCredito;
import br.edu.ifpb.padroes.chain.metodos.MetodoPagamentoChain;
import br.edu.ifpb.padroes.chain.metodos.Paypal;

import java.math.BigDecimal;

/**
 * Created by diogomoreira on 01/03/17.
 */
public class Loader {

    public static void main(String[] args) throws Exception {
        MetodoPagamentoChain pagamentos = new CartaoCredito(new BigDecimal("250"));
        pagamentos.setProximo(new CartaoCredito(new BigDecimal("5000")));
        pagamentos.setProximo(new Paypal(new BigDecimal("270")));

        pagamentos.efetuarPagamento(new BigDecimal("280"));
    }
}

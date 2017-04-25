package br.edu.ifpb.padroes.chain.metodos;

import java.math.BigDecimal;

/**
 * Created by diogomoreira on 01/03/17.
 */
public class CartaoCredito extends MetodoPagamentoChain {

    public CartaoCredito(BigDecimal saldo) {
        super(saldo);
    }

    protected void efetuaPagamento() {
        System.out.println("Pagamento efetuado com CC");
    }
}

package br.edu.ifpb.padroes.chain.metodos;

import java.math.BigDecimal;

/**
 * Created by diogomoreira on 01/03/17.
 */
public class Paypal extends MetodoPagamentoChain {

    public Paypal(BigDecimal saldo) {
        super(saldo);
    }

    protected void efetuaPagamento() {
        System.out.println("Pagamento efetuado no Paypal");
    }
}

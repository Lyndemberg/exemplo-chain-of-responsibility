package br.edu.ifpb.padroes.chain.metodos;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by diogomoreira on 01/03/17.
 */
public abstract class MetodoPagamentoChain {

    protected MetodoPagamentoChain proximo;
    protected BigDecimal saldo;

    public MetodoPagamentoChain(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void setProximo(MetodoPagamentoChain proximoMetodo) {
        if(proximo == null) {
            this.proximo = proximoMetodo;
        } else this.proximo.setProximo(proximoMetodo);
    }

    public void efetuarPagamento(BigDecimal quantia) throws Exception {
        if (podeEfetuarPagamento(quantia)) {
            efetuaPagamento();
        } else {
            if (proximo == null) {
                throw new Exception("Nao existem métodos de pagamento cadastrados que possam concluir a transaçao");
            }
            System.out.println("Nao foi possivel pagar. Tentando no proximo metodo...");
            proximo.efetuarPagamento(quantia);
        }
    }

    private boolean podeEfetuarPagamento(BigDecimal quantia) {
        if (saldo.compareTo(quantia) == 1 || saldo.compareTo(quantia) == 0) {
            return true;
        }
        return false;
    }

    protected abstract void efetuaPagamento();

}

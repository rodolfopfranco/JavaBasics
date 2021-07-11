package one.digitalinnovation.classes.z_modularizacao.src.operacao.internal;

import one.digitalinnovation.classes.z_modularizacao.src.operacao.Operacao;

public class SubHelper implements Operacao {
    @Override
    public int execute(int a, int b){
        return a-b;
    }
}

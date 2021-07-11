package one.digitalinnovation.classes.z_modularizacao.src.operacao;

import one.digitalinnovation.classes.z_modularizacao.src.operacao.internal.DivHelper;
import one.digitalinnovation.classes.z_modularizacao.src.operacao.internal.MultHelper;
import one.digitalinnovation.classes.z_modularizacao.src.operacao.internal.SubHelper;
import one.digitalinnovation.classes.z_modularizacao.src.operacao.internal.SumHelper;

public class Calculadora {

    private DivHelper divHelper;
    private MultHelper multHelper;
    private SubHelper subHelper;
    private SumHelper sumHelper;

    public Calculadora(){
        divHelper = new DivHelper();
        multHelper = new MultHelper();
        subHelper = new SubHelper();
        sumHelper = new SumHelper();
    }

    public int sum(int a, int b){
        return sumHelper.execute(a,b);
    }

    public int sub(int a, int b){
        return subHelper.execute(a,b);
    }
    public int div(int a, int b){
        return divHelper.execute(a,b);
    }
    public int mult(int a, int b){
        return multHelper.execute(a,b);
    }


}

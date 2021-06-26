package one.digitalinnovation.classes.z_streams;

import java.awt.event.ActionEvent;
import java.util.EventListener;

/*
    Qualquer Interface com SAM (Single Abstract Method)
    A implementação pode ser via expressões Lambda
 */
public class InterfaceFuncional {
}


//Com notação Functional Interface:
@FunctionalInterface
interface Comparator<T>{
    int compare(T var1, T var2);
}
//Sem notação Functional Interface:
interface ActionListener extends EventListener{
    void actionPerformed(ActionEvent var1);
}
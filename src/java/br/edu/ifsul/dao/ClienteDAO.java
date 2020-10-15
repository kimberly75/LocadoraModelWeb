package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Fabricante;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author kimberly.geremia
 */
@Stateful
public class ClienteDAO<TIPO> extends GenericDAO<Cliente> implements Serializable{
    public ClienteDAO(){
        super();
        classePersistente = Cliente.class;
    }
}

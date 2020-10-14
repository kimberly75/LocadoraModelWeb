/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Fabricante;
import java.io.Serializable;

/**
 *
 * @author kimberly.geremia
 */
public class FabricanteDAO<TIPO> extends GenericDAO<Fabricante> implements Serializable{
    public FabricanteDAO(){
        super();
        classePersistente = Fabricante.class;
    }
}

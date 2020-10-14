/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Grupo;
import java.io.Serializable;

/**
 *
 * @author kimberly.geremia
 */
public class GrupoDAO<TIPO> extends GenericDAO<Grupo> implements Serializable{
    public GrupoDAO(){
        super();
        classePersistente = Grupo.class;
    }
}

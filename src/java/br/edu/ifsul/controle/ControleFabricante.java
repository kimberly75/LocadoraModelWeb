/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.FabricanteDAO;
import br.edu.ifsul.modelo.Fabricante;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author kimberly.geremia
 */
@Named(value = "controleFabricante")
@ViewScoped
public class ControleFabricante implements Serializable{
   @EJB
    private FabricanteDAO<Fabricante> dao;
    private Fabricante objeto;

    public ControleFabricante() {

    }

    public String listar() {
        return "/privado/fabricante/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Fabricante();
    }

    public void alterar(Object id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception ex) {
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(ex));
        }
    }

    public void excluir(Object id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception ex) {
            Util.mensagemErro("Erro ao excluir objeto: " + Util.getMensagemErro(ex));
        }
    }
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        }catch (Exception ex) {
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(ex));
        }
    }

    public FabricanteDAO<Fabricante> getDao() {
        return dao;
    }

    public void setDao(FabricanteDAO<Fabricante> dao) {
        this.dao = dao;
    }

    public Fabricante getObjeto() {
        return objeto;
    }

    public void setObjeto(Fabricante objeto) {
        this.objeto = objeto;
    } 
}

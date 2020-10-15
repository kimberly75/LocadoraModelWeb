/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.ClienteDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Cliente;
import java.io.Serializable;
import br.edu.ifsul.util.Util;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author kimberly.geremia
 */
@Named(value = "controleCliente")
@ViewScoped
public class ControleCliente implements Serializable{
    @EJB
    private ClienteDAO<Cliente> dao;
    @EJB
    private CidadeDAO<Cidade> daoCidade;
    private Cliente objeto;
    
    public ControleCliente(){
        
    }
    
    public String listar() {
        return "/privado/cliente/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Cliente();
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

    public ClienteDAO<Cliente> getDao() {
        return dao;
    }

    public void setDao(ClienteDAO<Cliente> dao) {
        this.dao = dao;
    }

    public Cliente getObjeto() {
        return objeto;
    }

    public void setObjeto(Cliente objeto) {
        this.objeto = objeto;
    }

    public CidadeDAO<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDAO<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }
    
    
}

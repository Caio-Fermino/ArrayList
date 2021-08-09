/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author s.lucas
 */
public class Hardwares {
    public ArrayList<String> hardwares = new ArrayList();
    public ArrayList<String> backup = new ArrayList();
    
    public void adicionar(String time) {
        hardwares.add(time.toUpperCase());
        JOptionPane.showMessageDialog(null, "O Item " + time
                + " foi adicionado com sucesso!!");
    }

    public String listarTimes() {
        //30 iguais e 7 espaços vazios no  inicio
        String rel = "       Relação de Itens\n ==============================\n";
        if (!hardwares.isEmpty()) {
            for (int i = 0; i < hardwares.size(); i++) {
                rel += (i + 1) + " - " + hardwares.get(i) + "\n";
            }
        } else {
            rel = "Relação de Itens vazia!!";
        }
        return rel;
    }

    public void eliminar() {
        if (!hardwares.isEmpty()) {
            if (JOptionPane.showConfirmDialog(null, "Os dados serão eliminados de "
                    + "forma permanente, tem certeza que deseja fazer isso??",
                    "Eliminar Base <cuidado>",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                hardwares.clear();
                JOptionPane.showMessageDialog(null, "Os dados foram todos eliminados!");
            } else {
                JOptionPane.showMessageDialog(null, "Ação Cancelada com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "A base se encontra vazia...");
        }
    }
    
    public void backup() {
        if(!hardwares.isEmpty()){
                if(JOptionPane.showConfirmDialog(null, "Fazer backup ?", "Backup", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    backup = (ArrayList<String>) hardwares.clone();
                    JOptionPane.showMessageDialog(null, "Backup feito com sucesso!");
                }
                else 
                {
                JOptionPane.showMessageDialog(null, "Backup cancelado");
                }
        }    
        else{
                JOptionPane.showConfirmDialog(null, "Base vazia");
        }
        
    }
    public void restaurar(){
        if(JOptionPane.showConfirmDialog(null, "Restaurar base ?", "Restaurar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    hardwares = (ArrayList<String>) hardwares.clone();
                    JOptionPane.showMessageDialog(null, "Restauração feita com sucesso!");
                }
                else 
                {
                JOptionPane.showMessageDialog(null, "Restauração cancelada");
                }
    }
    public boolean retornarVazio() {
        return hardwares.isEmpty();
    }

    public int pesquisar(String nome) {
        boolean achou = false;
        int i, ind;
        ind = -1;
        i = 0;
        while (i < hardwares.size() && !(achou)) {
            if (hardwares.get(i).equals(nome.toUpperCase())) {
                achou = true;
                ind = i;
            }
            i++;
        }

        return ind;
    }

    public void excluir(int i) {
     
        hardwares.remove(i);
    }
    public void editar(int i, String novoNome){
        hardwares.set(i, novoNome);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinkojava;

import java.util.Scanner;

/**
 *
 * @author FACTORIUM
 */
public class kinko {

    
     Motoqueiro motoqueiro = new Motoqueiro();
     
    boolean limpo;
    boolean cheio;
    boolean aberto;
    int resposta;

    public void setLimpo(boolean limpo) {
        this.limpo = limpo;
    }

    public void setCheio(boolean cheio) {
        this.cheio = cheio;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public boolean isLimpo() {
        return limpo;
    }

    public boolean isCheio() {
        return cheio;
    }

    public boolean isAberto() {
        return aberto;
    }
    
    Scanner sc = new Scanner(System.in);

    
    public void abrirFechar(){
        if(aberto==true){
            aberto = false;
            System.out.println("O baú foi fechado!");
            
        }
        else{
             System.out.println("O báu foi aberto");
             aberto = true;
        }
    }
    
    //Método para encher ou esvaziar o baú
    public void encherEsvaziar(){
        //Verificando primeiramente se o baú está aberto
        if(aberto==false){ 
            System.out.println("Não foi possível, pois seu baú está fechado");
        }
        else{
            if(motoqueiro.isMascara()==true){
                if(cheio==false){
                    System.out.println("Sua encomenda já foi colocada no baú");
                    System.out.println("Digite sua senha novamente para fechar o baú");
                    motoqueiro.validaSenha();
                    if(motoqueiro.isSenhaCorreta()==false){
                        System.out.println("O baú NÃO foi fechado!");
                    }
                    else{
                        cheio = true;
                        System.out.println("Baú fechado!");
                       System.out.println("Pronto para entregar a encomenda!"); 
                       aberto = false;
                    }
                    
                    
            }
            else{
                System.out.println("Sua encomenda foi retirada do baú");
                cheio= false;
            }
            motoqueiro.resetSenha();
        }
            else{
                System.out.println("Por questão de segurança, não é possível manusear sua encomenda sem máscara");
                System.out.println("por favor coloque máscara antes de entregar qualquer encomenda!");
            }
        }

    }
    public void limpeza(){
        System.out.println("Verificando antes de limpeza!");
        verificaVazio();
        verificaAberto();
        if(this.isCheio()==false && this.isAberto()==false){
            this.setLimpo(true);
            System.out.println("Limpeza concluída com sucesso!");
        }
        else{
                    verificaVazio();
        verificaAberto();
        }
    }
    //Método para verificar se o báu está vazio ou cheio para limpeza
    public void verificaVazio(){
        if(this.isCheio()==true){
            System.out.println("Não foi possível realizar a limpeza, pois seu baú está cheio!");
            System.out.println("Esvazie ele antes");
         this.encherEsvaziar();
        }
        else{
            System.out.println("Ótimo, o baú está vazio!");
        }
    }
    //Método para verificar se o báu está aberto ou fechado para limpeza
    public void verificaAberto(){
        if(this.isAberto()==true){
            System.out.println("Não foi possível realizar a limpeza, pois seu baú está aberto!");
            motoqueiro.validaSenha();
             if(motoqueiro.isSenhaCorreta()==true){
                 System.out.println("O baú foi fechado com sucesso!");
                 this.setAberto(false);
             }
             motoqueiro.resetSenha();
        }
        else{
            System.out.println("O báu está fechado corretamente!");
        }
    }
}

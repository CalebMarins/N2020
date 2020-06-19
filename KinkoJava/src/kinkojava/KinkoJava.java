/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinkojava;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author FACTORIUM
 */
public class KinkoJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanners
        //Int
        Scanner sci = new Scanner(System.in);
        //String
        Scanner scs = new Scanner(System.in);
        
        //variáveis 
        boolean desligar = false;
        int classe;
        int resposta;
        
        //Trazendo classes
        kinko k = new kinko();
        Viagem v = new Viagem();
        
        //Ligando o aplicativo
        while(desligar == false){
            System.out.println("Bem vindo!");
            System.out.println("Realize seu cadastro!");
            k.motoqueiro.cadastroMotorista();
            k.motoqueiro.verificarCadastro();
            while(k.motoqueiro.acesso==true){
               System.out.println("/////////////////////////////////////////////////////////");
            System.out.println("O que você deseja fazer agora, "+ k.motoqueiro.getNome()+"?");
            System.out.println("Digite:");
            System.out.println("1 - Para área de Encomendas");
            System.out.println("2 - Para área da KINKO");
            System.out.println("3 - Para área de cadastro");
            System.out.println("4 - Colocar máscara");
            System.out.println("5 - Desligar");
            classe = sci.nextInt();
            
            switch(classe){
                //Área de encomendas
                case 1:
                    System.out.println("Agora digite");
                    System.out.println("1 - Entregar encomenda");
                    System.out.println("2 - Ver total de viagens já realizadas");
                    resposta = sci.nextInt();
                    //Entregar encomenda
                    if(resposta == 1){
                        if(k.isAberto() == false){
                        if(k.isCheio() == true){
                            v.entregue = true;
                        Date d = new Date();
                        System.out.println("Encomenda entregue:");
                        System.out.println("Seu baú está vazio novamente!");
                        k.setCheio(false);
                        System.out.println(d);
                        v.entregue =true;
                        v.setTotalEntregas(v.getTotalEntregas()+1);
                        }
                        else{
                            System.out.println("O baú está vazio, coloque a encomenda, antes de entregar!");
                            k.motoqueiro.validaSenha();
                            k.abrirFechar();
                            k.encherEsvaziar();
                        }  
                    }
                    else{
                        System.out.println("O baú está aberto, feche ele antes de viajar!");
                        k.motoqueiro.validaSenha();
                        k.abrirFechar();
                    }
                    }
                    //Total de viagens realizadas
                    else{
                        System.out.println("Total de entregas já feitas: "+ v.getTotalEntregas() );
                    }
                    break;
                    
                //Área KINKO
                case 2:
                    k.motoqueiro.verificarCadastro();
                    if(k.motoqueiro.isAcesso()==true){
                        System.out.println("Área KINKO");
                    System.out.println("Agora digite");
                    System.out.println("1 - Colocar ou tirar sua encomenda no baú");
                    System.out.println("2 - Realizar a limpeza do baú");
                    resposta = sci.nextInt();
                    switch(resposta){
                        //Colocar ou tirar encomendas do baú
                        case 1:
                            //Verificando se o motorista está de máscara para retirar a encomenda
                            k.motoqueiro.validarMascara();
                            k.motoqueiro.validaSenha();
                            if(k.motoqueiro.isSenhaCorreta()==true){
                                if(k.isAberto()==true){
                                    System.out.println("O baú estava aberto e será fechado!");
                                }
                                else{
                                    System.out.println("O baú estava fechado e será aberto!");
                                    
                                }
                                k.abrirFechar();
                            }
                            k.motoqueiro.resetSenha();
                            k.encherEsvaziar();
                            
                            break;
                            
                        case 2:
                            k.limpeza();
                    }
                    }
                    
                    break;
                    
                //Caso selecionado o motorista
                case 3:
                    System.out.println("ÁREA DO CADASTRADO");
                    System.out.println("Digite:");
                    System.out.println("1- Editar seus dados");
                    System.out.println("2- Visualizar seus dados");
                    resposta = sci.nextInt();
                    if(resposta==1){
                            k.motoqueiro.cadastroMotorista();
                    }
                    else{
                    k.motoqueiro.visualizarMotorista();
                    }
                    break;
                    
                case 4:
                    System.out.println("Para prevenir o COVID-19, aconselhamos sempre o uso de máscaras");
                    k.motoqueiro.validarMascara();
                    break;
                   
                case 5:
                    desligar = true;
                    k.motoqueiro.acesso = false;
                    break;
            }
            }
        }
    }  
}

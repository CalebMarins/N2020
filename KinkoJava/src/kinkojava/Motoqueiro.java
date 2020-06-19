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
public class Motoqueiro {
    
    
       //Scanners
       //Int
       Scanner sci = new Scanner(System.in);
       //String
       Scanner scs = new Scanner(System.in);
    
    
    
    private String nome;
    public boolean mascara;
    private String email;
    private String senha;
    boolean acesso = false;
    boolean senhaCorreta = false;

    public boolean isSenhaCorreta() {
        return senhaCorreta;
    }

    public boolean isAcesso() {
        return acesso;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public Motoqueiro() {
     
    }
    
    public String getNome() {
        return nome;
    }

    public boolean isMascara() {
        return mascara;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMascara(boolean mascara) {
        this.mascara = mascara;
    } 

//Método construtor
    public Motoqueiro(String nome, boolean mascara, String digitalCode){
        this.nome= nome;
        this.mascara = mascara;
        this.email= digitalCode;
    }
    
     //Método para validar máscara
    public void validarMascara(){
        if(isMascara()==false){
             System.out.println("Deseja colocar a máscara?");
             System.out.println("1 - Sim / 2 - Não ");
             int n;
             n =sci.nextInt();

             if(n==1){
                this.colocarMascara();
             }
             else{
                 System.out.println("Você não colocou a máscara :(");
             }
        }
        else{
            System.out.println("Você já está usando corretamente a máscara!");
        }
    }
    
    public void colocarMascara(){
        setMascara(true);
        System.out.println("Você colocou a máscara :)");
    }
    
    //Método para cadastro de motorista
    public void cadastroMotorista(){
         System.out.print("Nome: ");
         String nome = scs.nextLine();
         this.setNome(nome);
         System.out.print("Email: ");
         String email = scs.nextLine();
         this.setEmail(email);
         System.out.print("Senha: ");
         String senha = scs.nextLine();
         this.setSenha(senha);
         System.out.println("Seu novo cadastro foi criado!");
    }
    
    //Método para visualizar o motoristaa cadastrado
    public void visualizarMotorista(){
        System.out.println("Nome: "+ this.getNome());
        System.out.println("Email: "+ this.getEmail());
        System.out.println("Sua senha é confidencial, deseja mostrar?");
        System.out.println("Digite 1 para sim e 2 para não");
        int n = sci.nextInt();
        if(n==1){
            System.out.println("Senha: "+ this.getSenha());
        }
        else{
            System.out.println("Você selecionou não");
        }
    }
    
    //Método para cadastro do motoqueiro
    public void verificarCadastro(){
        //Validando primeiramente se o usuário realizou cadastro
        if(nome==null && email==null && senha==null){
            System.out.println("Erro!");
            System.out.println("Você precisa ser cadastrado para completar essa ação!");
        }
        //Validando se ele já tem um cadastro, mas estpa incompleto
        else if(nome==null || email==null || senha==null){
            System.out.println("Erro!");
            System.out.println("Preencha corretamente TODOS os dados para concluir o cadastro e poder prosseguir!");
        }
        //Caso o cadastro dele esteja completo
        else{
            acesso =true;
        }
    }
    
    //Método para verificar a senha
    public void validaSenha(){
        System.out.println("Digite sua senha para prosseguir:");
        String pass = scs.nextLine();
        if(senha.equals(pass)){
            System.out.println("Sua senha está correta!");
            senhaCorreta = true;
        }
        else{
            System.out.println("Senha incorreta!");
        }

    }
    
    public void resetSenha(){
        senhaCorreta = false;
    }
}


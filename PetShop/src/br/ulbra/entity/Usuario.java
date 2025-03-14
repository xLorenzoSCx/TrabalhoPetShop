package br.ulbra.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Usuario {

    private int pkidUsu;
    private String nomeUsu;
    private String emailUsu;
    private String senhaUsu;
    private String foneUsu;
    private String cpfUsu;
    private String enderecoUsu;

    public Usuario() {
    }

    // Construtor padrão e completo
    public Usuario(int id, String nome, String email, String senha, String fone, String cpf, String endereco) {
    }

    @Override
    public String toString() {
        return " ID:    " + this.pkidUsu
                + " Nome:  " + this.nomeUsu
                + " E-mail:" + this.emailUsu
                + " Senha: " + this.senhaUsu
                + " Fone:  " + this.foneUsu;

    }

    //setters e getters
    public int getPkidUsu() {
        return pkidUsu;
    }

    public void setPkidUsu(int pkidUsu) {
        this.pkidUsu = pkidUsu;
    }

    public String getNomeUsu() {
        return nomeUsu;
    }

    public void setNomeUsu(String nomeUsu) {
        this.nomeUsu = nomeUsu;
    }

    public String getEmailUsu() {
        return emailUsu;
    }

    public void setEmailUsu(String emailUsu) {
        this.emailUsu = emailUsu;
    }

    public String getSenhaUsu() {
        return senhaUsu;
    }

    public void setSenhaUsu(String senhaUsu) {
        this.senhaUsu = senhaUsu;
    }

    public String getFoneUsu() {
        return foneUsu;
    }

    public void setFoneUsu(String foneUsu) {
        this.foneUsu = foneUsu;
    }

    public String getCpfUsu() {
        return cpfUsu;
    }

    public void setCpfUsu(String cpfUsu) {
        this.cpfUsu = cpfUsu;
    }

    public String getEnderecoUsu() {
        return enderecoUsu;
    }

    public void setEnderecoUsu(String enderecoUsu) {
        this.enderecoUsu = enderecoUsu;
    }

    public boolean validarSenha(String senha) {
        if (senha.length() >= 8) {

            return true;
        }
        //verificar se a senha atende aos requisitos
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
        return senha.matches(regex);

    }

    public boolean validarCpf(String cpf) {
        if (cpf.length() != 11) {
            return false;

        }

        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
                || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
                || cpf.equals("99999999999")) {
            return false;
        }

        return true;
    }

    public boolean confirmarSenha(String senha, String senhaConfirmada) {
        if (senha.equals(senhaConfirmada)) {
            return true;
        }
         return false;
       

    }

}

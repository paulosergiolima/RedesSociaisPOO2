package com.perdi.backend.userpkg;

public class UserFactory {
    public static User createUser(String userName, String nickName, String email, String pronouns, String profileDescription, Boolean accountPrivacy){
        /**
            * Factory do Usuário para privar a lógica de construção do usuário
            *
            * @param userName nome real do usuário
            * @param nickName apelido que o usuário pode usar na rede social
            * @param email email utilizado do usuário
            * @param pronouns pronome utilizado pelo usuário
            * @param profileDescription descrição do perfil do usuário
            * @param accountPrivacy privacidade da conta do usuário, que pode ser pública ou privada
            * @return um novo objeto User sem sua lógica de criação
        */
        
        /**
         * @throws IllegalArgumentException quando o usuário não possui um nome
        */
        
        if(userName == null || userName.isBlank()){
            throw new IllegalArgumentException("Nome de usuário não pode ser vázio");
        }
        
        /**
         * @throws IllegalArgumentException se o e-mail está vazio ou ele não possui o "@"
        */
        
        if(email == null || email.isBlank() || !email.contains("@")){
            throw new IllegalArgumentException("E-mail inválido");
        }
        
        if(pronouns == null || pronouns.isBlank()){
            pronouns = "Não especificado"; // Valor padrão
        }
        
        if(accountPrivacy == null){
            accountPrivacy = true; // Valor padrão
        }

        /**
         * @return novo usuário sem sua lógica exibida
         */
        return new User(userName, nickName, email, pronouns, profileDescription, accountPrivacy);
    }
        
}

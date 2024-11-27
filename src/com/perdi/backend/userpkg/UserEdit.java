package com.perdi.backend.userpkg;

public class UserEdit{

    /**
     * Edição de usuário
     * 
     * @param userName nome verdadeiro do usuário
     * @param nickName apelido do usuário para a rede
     * @param email email cadastrado
     * @param pronouns pronome utilizado
     * @param profileDescription descrição do perfil do usuário
     * @param accountPrivacy privacidade da conta, que pode ser pública ou privada
     * @throws IllegalArgumentException que o usuário não existe
     */

    public void editUser(User user, String userName, String nickName, String email, String pronouns, String profileDescription, Boolean accountPrivacy) {

        if(user == null){
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        
        // Atualizar campos se os novos valores não forem nulos ou inválidos
        if(userName != null && !userName.isBlank()){
            user.setUserName(userName);
        }

        if(nickName != null && !nickName.isBlank()){
            user.setNickName(nickName);
        }

        if(email != null && !email.isBlank()){
            user.setEmail(email);
        }

        if(pronouns != null) {
            user.setPronouns(pronouns);
        }

        if(profileDescription != null){
            user.setProfileDescription(profileDescription);
        }

        if(accountPrivacy != null){
            user.setAccountPrivacy(accountPrivacy);
        }

        System.out.println("Usuário editado com sucesso: " + user.getUserName());
    }
}


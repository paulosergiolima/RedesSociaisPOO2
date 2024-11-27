package com.perdi.backend.userpkg;

public class UserEdit{

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


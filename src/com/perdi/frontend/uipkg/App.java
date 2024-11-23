package com.perdi.frontend.uipkg;

import com.perdi.backend.storage.datapkg.DataCenter;
import com.perdi.backend.storage.datapkg.UserPersistence;
import com.perdi.backend.feed.postpkg.Post;
import com.perdi.backend.feed.postpkg.TextPost;
import com.perdi.backend.systempkg.reccomendationpkg.Recommendation;
import com.perdi.backend.userpkg.User;

import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        DataCenter dataCenter = DataCenter.getInstance();
        UserPersistence userPersistence = UserPersistence.getInstance();
        // Criando usuários
        User user1 = new User("joao_doe", "João", "joao@example.com", "he/him", "Adoro programar!", true);
        User user2 = new User("maria_silva", "Maria", "maria@example.com", "she/her", "Amo a natureza!", true);
        User user3 = new User("lucas_oliveira", "Lucas", "lucas@example.com", "they/them", "Viciado em jogos!", false);

        // Testando a funcionalidade de seguir e quantidade de seguidores
        user1.followUser(user2);
        user1.followUser(user3);
        System.out.println("João está seguindo: " + user1.followingQuanitty() + " usuários.");
        System.out.println("Maria tem: " + user2.followersQuantity() + " seguidores.");

        // Testando a funcionalidade de bloquear usuário
        user1.blockUser(user3);
        System.out.println("João tem " + user1.getBlockedUsers().size() + " usuários bloqueados.");
        System.out.println("Lucas está bloqueado? " + user1.getBlockedUsers().contains(user3));

        // Testando a funcionalidade de desbloquear usuário
        user1.unblockUser(user3);
        System.out.println("João tem " + user1.getBlockedUsers().size() + " usuários bloqueados.");
        System.out.println("Lucas está bloqueado? " + user1.getBlockedUsers().contains(user3));

        // Testando a funcionalidade de criar e remover posts
        user1.addTextPost("Meu primeiro post!");
        System.out.println("João tem " + user1.getUserPost().size() + " posts.");
        TextPost post = (TextPost) user1.getUserPost().get(0); // Pegando o primeiro post de João
        post.addView();
        post.addView();
        post.addView();
        post.addView();
        post.addView();

        user2.addTextPost("batata!");
        TextPost post2 = (TextPost) user2.getUserPost().get(0); // Pegando o primeiro post de João
        post2.addView();
        System.out.println("User1 Reccomend ");
        ArrayList<Post> posts = Recommendation.getWeeklyRecommendation(user1);

        System.out.println("User2 Reccomend ");
        ArrayList<Post> posts2 = Recommendation.getWeeklyRecommendation(user2);

        // Testando a edição de perfil
        user1.editProfile("joao_doe_updated", null, "novo_email@example.com", null, "Agora sou mais experiente!", null);
        System.out.println("Novo nome de usuário de João: " + user1.getUserName());
        System.out.println("Novo e-mail de João: " + user1.getEmail());
        System.out.println("Nova descrição de perfil de João: " + user1.getProfileDescription());

        dataCenter.addUser(user1);
        dataCenter.addUser(user2);
        dataCenter.addUser(user3);

        userPersistence.saveUsers(dataCenter.getUsers());

        System.out.println("Trazendo usuarios para o armazenamento local...");
        for (User user : userPersistence.loadUsers()) {
            dataCenter.addUser(user);
        }

        System.out.println("Imprimindo usuarios:");
        for (User user : dataCenter.getUsers()) {
            System.out.println("ID: " + user.getId());
            System.out.println("Username: " + user.getUserName());
            System.out.println("Nickname: " + user.getNickName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Pronomes: " + user.getPronouns());
            System.out.println("Descricao: " + user.getProfileDescription());
            System.out.println("Data de criacao da conta: " + user.getCreationDate());


            System.out.println("Seguidores: ");
            if (user.getFollowers().isEmpty()) {
                System.out.println("Nenhum seguidor.");
            } else {
                for (User follower : user.getFollowers()) {
                    System.out.println(follower.getUserName() + " ");
                }
                System.out.println();
            }

            System.out.println("Seguindo: ");
            if (user.getFollowing().isEmpty()) {
                System.out.println("Nao segue ninguem.");
            } else {
                for (User followed : user.getFollowing()) {
                    System.out.println(followed.getUserName() + " ");
                }
                System.out.println();
            }

            System.out.println("Usuarios Bloqueados: ");
            if (user.getBlockedUsers().isEmpty()) {
                System.out.println("Nenhum usuario bloqueado.");
            } else {
                for (User bloccked : user.getBlockedUsers()) {
                    System.out.println(bloccked.getUserName() + " ");
                }
                System.out.println();
            }
            System.out.println("Posts: ");
            if (user.getUserPost().isEmpty()) {
                System.out.println("Nenhum post.");
            } else {
                for (Post p : user.getUserPost()) {
                    System.out.println("  - " + ((TextPost) p).getPostTextContent());
                }
            }
            System.out.println();
        }
    }
}

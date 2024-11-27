package com.perdi.backend.userpkg;

public class FollowersFollowing implements FollowManager{

    @Override
    public boolean follow(User follower, User following){
        // Validações
        if(follower == null || following == null){
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }

        if(follower.equals(following)){
            System.out.println("Usuário não pode seguir a si mesmo.");
            return false;
        }

        if(follower.getBlockedUsers().contains(following) || following.getBlockedUsers().contains(follower)){
            System.out.println("Não pode seguir ou ser seguido por um usuário bloqueado.");
            return false;
        }

        // Verifica se já está seguindo
        if(!follower.getFollowing().contains(following)){
            follower.getFollowing().add(following);
            following.getFollowers().add(follower);
            System.out.println(follower.getUserName() + " está seguindo " + following.getUserName());
            return true;
        }

        System.out.println(follower.getUserName() + " já está seguindo " + following.getUserName());
        return false;
    }

    @Override
    public boolean unfollow(User follower, User toUnfollow) {
        if(follower == null || toUnfollow == null){
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }

        // Remove das listas
        if(follower.getFollowing().remove(toUnfollow)){
            toUnfollow.getFollowers().remove(follower);
            System.out.println(follower.getUserName() + " deixou de seguir " + toUnfollow.getUserName());
            return true;
        }

        System.out.println(follower.getUserName() + " não está seguindo " + toUnfollow.getUserName());
        return false;
    }

    @Override
    public boolean removeFollower(User user, User follower) {
        if(user == null || follower == null){
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }

        // Remove seguidor
        if (user.getFollowers().remove(follower)) {
            follower.getFollowing().remove(user);
            System.out.println(follower.getUserName() + " foi removido da lista de " + user.getUserName() + " de seguidores");
            return true;
        }

        System.out.println(follower.getUserName() + " não é um seguidor de " + user.getUserName());
        return false;
    }

    @Override
    public int getFollowersCount(User user) {
        if(user == null){
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        return user.getFollowers().size();
    }

    @Override
    public int getFollowingCount(User user) {
        if(user == null){
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        return user.getFollowing().size();
    }
}

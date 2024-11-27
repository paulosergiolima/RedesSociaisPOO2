package com.perdi.backend.userpkg;

public class FollowersFollowing implements FollowManager{

    /**
     * Seguir um usuário e ser seguido
     * 
     * @param follower é um User que indica quem recebera um seguidor
     * @param following é um User quem será seguido 
     * @return True no caso de ter sido seguido e False caso já seja seguido
    */

    @Override
    public boolean follow(User follower, User following){
        

        if(follower == null || following == null){
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }

        if(follower.equals(following)){
            System.out.println("Usuário não pode seguir a si mesmo.");
            return false;
        }

        if (follower.isUserBlocked(following) || following.isUserBlocked(follower)) {
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

    /**
     * Parar de seguir
     * 
     * @param follower é o User que possui um seguidor
     * @param toUnfollow é o User seguido que não será mais seguido
     * @return True no caso de sucesso e False caso já não siga mais
    */

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

    /**
     * Remover um seguidor
     * 
     * @param user usuário que deseja remover o seguidor
     * @param follower o seguidor que será removido
     * @return True no caso de remoção e False caso já esteja removido
    */

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

    /**
     * Resgatar a quantidade de seguidores 
     * 
     * @param user o usuário a ver a quantidade de seguidores
     * @return a quantidade inteira de usuários que seguem
    */

    @Override
    public int getFollowersCount(User user) {
        if(user == null){
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        return user.getFollowers().size();
    }

    /**
     * Resgatar a quantidade de seguindo
     * 
     * @param user o usuário a ver a quantidade de seguindo
     * @return a quantidade inteira de pessoas que o usuário segue
    */

    @Override
    public int getFollowingCount(User user) {
        if(user == null){
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        return user.getFollowing().size();
    }
}

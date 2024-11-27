package com.perdi.backend.userpkg;

import java.util.Set;

public class BlockUser implements BlockManager{

    /**
     * Método para bloquear usuário
     * 
     * @param blocker usuário que está bloqueando
     * @param toBlock usuário que será bloqueado
     * @return True caso o usuário seja bloqueado
    */
    
    @Override
    public boolean blockUser(User blocker, User toBlock) {
        if(blocker == null || toBlock == null){
            throw new IllegalArgumentException("Usuários não podem ser nulos.");
        }

        if(blocker.equals(toBlock)){
            System.out.println("Usuário não pode bloquear a si mesmo.");
            return false;
        }

        Set<User> blockedUsers = blocker.getBlockedUsers();
        if(blockedUsers.add(toBlock)){
            System.out.println(blocker.getUserName() + " bloqueou " + toBlock.getUserName());
            return true;
        }

        System.out.println(toBlock.getUserName() + " já está bloqueado por " + blocker.getUserName());
        return false;
    }

    /** 
     * Método para desbloquear usuário
     * 
     * @param blocker usuário que bloqueou
     * @param toUnblock usuario que será desbloqueado
     * @return True caso seja desbloqueado
    */

    @Override
    public boolean unblockUser(User blocker, User toUnblock) {
        if(blocker == null || toUnblock == null){
            throw new IllegalArgumentException("Usuários não podem ser nulos.");
        }

        Set<User> blockedUsers = blocker.getBlockedUsers();
        if(blockedUsers.remove(toUnblock)){
            System.out.println(blocker.getUserName() + " desbloqueou " + toUnblock.getUserName());
            return true;
        }

        System.out.println(toUnblock.getUserName() + " não estava bloqueado por " + blocker.getUserName());
        return false;
    }

    /**
     * Método para verificar se usuário foi bloqueado
     * 
     * @param blocker usuário que possivelmente bloqueou
     * @param toCheck usuário que será checado
     * @return True se o usuário foi bloqueado
    */
    @Override
    public boolean isUserBlocked(User blocker, User toCheck) {
        if(blocker == null || toCheck == null){
            throw new IllegalArgumentException("Usuários não podem ser nulos.");
        }

        return blocker.getBlockedUsers().contains(toCheck);
    }
}

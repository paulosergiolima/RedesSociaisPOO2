package com.perdi.backend.userpkg;

import java.util.Set;

public class BlockUser implements BlockManager{
    
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

    @Override
    public boolean isUserBlocked(User blocker, User toCheck) {
        if(blocker == null || toCheck == null){
            throw new IllegalArgumentException("Usuários não podem ser nulos.");
        }

        return blocker.getBlockedUsers().contains(toCheck);
    }
}

package cf.cours.dao;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import cf.cours.model.User;

public interface Dao<T> {
    /**
     * Récupère un utilisateur
     * @param id Login de l'utilisateur
     * @return Un java.util.Optional qui contient (ou pas) l'utilisateur
     */
    User get(String id);

    /**
     * Récupère tous les utilisateurs
     * @return Un Set de login
     */
    List<User> getAll();

    /**
     * Crée un utilisateur et le sauvegarde
     * @param t L'utilisateur à créer
     */
    void save(T t);

    /**
     * Modifie un utilisateur
     * @param t L'utilisateur à modifier
     * @param params Un tableau de **2** Strings : login et password
     */
    void update(T t, String[] params);

    /**
     * Supprime un utilisateur
     * @param t L'utilisateur à supprimer
     */
    void delete(T t);
}

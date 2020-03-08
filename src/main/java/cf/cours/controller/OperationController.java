package cf.cours.controller;


import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cf.cours.dao.Dao;
import cf.cours.model.User;

@CrossOrigin("*")
@RestController
public class OperationController {
	
	// TODO récupérer le DAO...
	@Autowired
	Dao<User> dao;

    /**
     * Procédure de login "simple" d'un utilisateur
     * @param login Le login de l'utilisateur. L'utilisateur doit avoir été créé préalablement et son login doit être présent dans le DAO.
     * @param password Le password à vérifier.
     * @return Une ResponseEntity avec le JWT dans le header "Authentication" si le login s'est bien passé, et le code de statut approprié (204, 401 ou 404).
     */
	
    @PostMapping("/login")
    public void login(@RequestParam("login") String login,@RequestParam("password") String password) {

    	User u =  dao.get(login);
    	try {
			u.authenticate(password);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		u.isConnected();	
		
    }
    
    @PostMapping("/register")
    public void register(@RequestParam("login") String login,@RequestParam("password") String password) {
    	User u =  new User(login,password);
    	
		dao.save(u);	
		
    }

    /**
     * Réalise la déconnexion
     */
    @DeleteMapping("/logout")
    // TODO
    public void Deconnection(@RequestParam("login") String login) {    	
    	User u = dao.get(login);
    	dao.delete(u);
    }

    /**
     * Méthode destinée au serveur Node pour valider l'authentification d'un utilisateur.
     * @param token Le token JWT qui se trouve dans le header "Authentication" de la requête
     * @param origin L'origine de la requête (pour la comparer avec celle du client, stockée dans le token JWT)
     * @return Une réponse vide avec un code de statut approprié (204, 400, 401).
     */
    @GetMapping("/authenticate")
    public ResponseEntity<Void> authenticate(@RequestParam("token") String token, @RequestParam("origin") String origin) {
        // TODO
    	return null;
    }


}

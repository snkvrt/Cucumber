Feature: Connexion échouée

    @KO
  Scenario: Connexion échouée
    Given l'utilisateur est sur la page de connexion "https://www.saucedemo.com/"
    When l'utilisateur insère son identifiant invalide dans le champ associé "stndard_user"
    And qu'il insère son mot de passe invalide dans le champ associé "secrt_sauce"
    And qu'il appuie sur le bouton connexion
    Then la connexion de l'utilisateur échoue

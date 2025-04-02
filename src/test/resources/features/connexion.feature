Feature: La connexion réussi



  @TNR
  Scenario: Connexion réussie
    Given l'utilisateur est sur la page de connexion "https://www.saucedemo.com/"
      When l'utilisateur insère son identifiant valide dans le champ associé "standard_user"
      And qu'il insère son mot de passe valide dans le champ associé "secret_sauce"
      And qu'il appuie sur le bouton connexion
      Then l'utilisateur se connecte avec succès












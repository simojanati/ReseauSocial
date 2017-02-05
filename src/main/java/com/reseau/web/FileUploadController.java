package com.reseau.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.reseau.model.Classe;
import com.reseau.model.Poste;
import com.reseau.model.Type;
import com.reseau.model.Utilisateur;
import com.reseau.service.IClasseService;
import com.reseau.service.IPosteService;
import com.reseau.service.IRelationService;
import com.reseau.service.ITypeService;
import com.reseau.service.IUtilisateurService;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {

	private static String UPLOADED_FOLDER_IMAGES = "target/classes/static/dist/imagesPoste/";
	private static String UPLOADED_FOLDER_FILES = "target/classes/static/dist/tmpFiles/";
	
	@Autowired
	private IUtilisateurService utilisateurMetier;
	@Autowired
	private IPosteService posteMetier;
	@Autowired
	private ITypeService typeMetier;
	@Autowired
	private IClasseService classeMetier;
	@Autowired
	private IRelationService relationMetier;
	
	@RequestMapping(value = "/ajouterStatut", method = RequestMethod.POST)
	public String uploadFileHandler(MultipartFile file, String type, String statut, String username) {
		Utilisateur utilisateur2 = null;
		try {
			Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
			utilisateur2 = utilisateurMetier.afficherUnUtilisateur(username);
			System.out.println(utilisateur.getUsername());
			Type type2 = typeMetier.afficherTypeParNom(type);
			System.out.println(type2.getMessage());
			String name = null;
			
			if(type.equals("Text")){
				posteMetier.ajouterPoste(statut, new Date(), type2, null, null, utilisateur, utilisateur2, false);
			}else if(type.equals("Image")){
				name = utilisateur.getUsername()+"_"+file.getOriginalFilename();
				posteMetier.ajouterPoste(statut, new Date(), type2, singleImageUpload(file,utilisateur), name, utilisateur, utilisateur2, false);
			}else if(type.equals("Fichier")){
				name = utilisateur.getUsername()+"_"+file.getOriginalFilename();
				posteMetier.ajouterPoste(statut, new Date(), type2, singleFileUpload(file,utilisateur), name, utilisateur, utilisateur2, false);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/profileChercher?username="+utilisateur2.getUsername();
	}
	
	@RequestMapping(value = "/ajouterStatutP", method = RequestMethod.POST)
	public String uploadFileHandler1(MultipartFile file, String type, String statut) {
		try {
			Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
			System.out.println(utilisateur.getUsername());
			Type type2 = typeMetier.afficherTypeParNom(type);
			System.out.println(type2.getMessage());
			String name = null;
			
			if(type.equals("Text")){
				posteMetier.ajouterPoste(statut, new Date(), type2, null, null, utilisateur, null, false);
			}else if(type.equals("Image")){
				name = utilisateur.getUsername()+"_"+file.getOriginalFilename();
				posteMetier.ajouterPoste(statut, new Date(), type2, singleImageUpload(file,utilisateur), name, utilisateur, null, false);
			}else if(type.equals("Fichier")){
				name = utilisateur.getUsername()+"_"+file.getOriginalFilename();
				posteMetier.ajouterPoste(statut, new Date(), type2, singleFileUpload(file,utilisateur), name, utilisateur, null, false);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/profile";
	}
	
	@RequestMapping(value = "/ajouterStatutM", method = RequestMethod.POST)
	public String uploadFileHandler2(MultipartFile file, String type, String statut) {
		try {
				Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
				System.out.println(utilisateur.getUsername());
				Type type2 = typeMetier.afficherTypeParNom(type);
				System.out.println(type2.getMessage());
				String name = null;
				if(type.equals("Text")){
					posteMetier.ajouterPoste(statut, new Date(), type2, null, null, utilisateur, null, false);
				}else if(type.equals("Image")){
					name = utilisateur.getUsername()+"_"+file.getOriginalFilename();
					posteMetier.ajouterPoste(statut, new Date(), type2, singleImageUpload(file,utilisateur), name, utilisateur, null, false);
				}else if(type.equals("Fichier")){
					name = utilisateur.getUsername()+"_"+file.getOriginalFilename();
					posteMetier.ajouterPoste(statut, new Date(), type2, singleFileUpload(file,utilisateur), name, utilisateur, null, false);
				}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/ajouterStatutG", method = RequestMethod.POST)
	public String uploadFileHandler3(MultipartFile file, String type, String statut, Long idGroupe) {
		Classe classe = new Classe();
		try {
			Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
			System.out.println(utilisateur.getUsername());
			Type type2 = typeMetier.afficherTypeParNom(type);
			System.out.println(type2.getMessage());
			classe = classeMetier.afficherUneClasseParId(idGroupe);
			String name = null;
			
			if(type.equals("Text")){
				Poste poste = posteMetier.ajouterPoste(statut, new Date(), type2, null, null, utilisateur, null, true);
				relationMetier.ajouterRelation(classe, poste);
			}else if(type.equals("Image")){
				name = utilisateur.getUsername()+"_"+file.getOriginalFilename();
				Poste poste = posteMetier.ajouterPoste(statut, new Date(), type2, singleImageUpload(file,utilisateur), name, utilisateur, null, true);
				relationMetier.ajouterRelation(classe, poste);
			}else if(type.equals("Fichier")){
				name = utilisateur.getUsername()+"_"+file.getOriginalFilename();
				Poste poste = posteMetier.ajouterPoste(statut, new Date(), type2, singleFileUpload(file,utilisateur), name, utilisateur, null, true);
				relationMetier.ajouterRelation(classe, poste);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/groupe?idGroupe="+classe.getIdClasse();
	}
	
    public String singleImageUpload(MultipartFile file, Utilisateur utilisateur) {

        if (file.isEmpty()) {
            return null;
        }
        String name = null;
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            name = utilisateur.getUsername()+"_"+file.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FOLDER_IMAGES + name);
            Files.write(path, bytes);
            System.out.println("message : You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/dist/imagesPoste/"+name;
    }
    
    public String singleFileUpload(MultipartFile file, Utilisateur utilisateur) {

        if (file.isEmpty()) {
            return null;
        }
        String name = null;
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            name = utilisateur.getUsername()+"_"+file.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FOLDER_FILES + name);
            Files.write(path, bytes);
            System.out.println("message : You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/dist/tmpFiles/"+name;
    }

	
}
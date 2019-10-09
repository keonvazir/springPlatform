package com.mvc.language.services;


import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mvc.language.models.Lang;
import com.mvc.language.repositories.LangRepo;

@Service
public class LangService {
    // adding the book repository as a dependency
    private final LangRepo langRepo;
    
    public LangService(LangRepo langRepo) {
        this.langRepo = langRepo;
    }
   
    public List<Lang> allLangs() {
        return langRepo.findAll();
    }
   
    public Lang createOrUpdateLang(Lang user) {
        return langRepo.save(user);
    }
   
//    public Lang findLang(Long id) {
//        Optional<Lang> optionalLang = langRepo.findById(id);
//        if(optionalLang.isPresent()) {
//            return optionalLang.get();
//        } else {
//            return null;
//        }
//    }
//	public Lang updateLang(Long id, String name, String creator, Float version) {
//		Lang new_lang = findLang(id);
//		if(new_lang == null) {
//		return null;
//		}
//		new_lang.setName(name);
//		new_lang.setCreator(creator);
//		new_lang.setVersion(version);
//		
//		
//		return langRepo.save(new_lang);
//	}
//	public void deleteLang(Long id) {
//        Optional<Lang> optionalBook = langRepo.findById(id);
//        if(optionalBook.isPresent()) {
//            langRepo.deleteById(id);
//        }
//    }
}




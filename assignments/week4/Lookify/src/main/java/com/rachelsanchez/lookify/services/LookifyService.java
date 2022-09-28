package com.rachelsanchez.lookify.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rachelsanchez.lookify.models.Lookify;
import com.rachelsanchez.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {

		@Autowired
		private LookifyRepository lookifyRepository;
		
		public LookifyService(LookifyRepository LookifyRepository) {
			this.lookifyRepository = lookifyRepository;
		}
		
//		fetch all lookify attributes
		
		public List allSongs() {
			return (List) this.lookifyRepository.findAll();
		}
		

		public LookifyRepository getLookifyRepository() {
			return lookifyRepository;
		}

		public void setLookifyRepository(LookifyRepository lookifyRepository) {
			this.lookifyRepository = lookifyRepository;
		}

		public Lookify findSong(Long id) {
		    Optional<Lookify> optSong = lookifyRepository.findById(id);
		      if(optSong.isPresent()) {
		          return optSong.get();
		      } else {
		          return null;
		      }
		}
		
		public Lookify findSongsByArtist(Lookify artist) {
		    Lookify optSong = lookifyRepository.findByArtist(artist);
		      if(optSong.isPresent()) {
		          return optSong.get(optSong);
		      } else {
		          return null;
		      }
		}
		public Lookify createSong(Lookify lookify) {
			// TODO Auto-generated method stub
			return lookifyRepository.save(lookify);
		}

		public void destroy(Long id) {
			// TODO Auto-generated method stub
			lookifyRepository.deleteById(id);
		}
		
		public Lookify findSong(Lookify rating) {
		    Lookify optSong = lookifyRepository.findTop(rating);
		      if(optSong.isPresent()) {
		          return optSong.get(optSong);
		      } else {
		          return null;
		      }
		}

}

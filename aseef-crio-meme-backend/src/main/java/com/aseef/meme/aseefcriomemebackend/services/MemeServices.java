package com.aseef.meme.aseefcriomemebackend.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aseef.meme.aseefcriomemebackend.model.Meme;
import com.aseef.meme.aseefcriomemebackend.repository.MemeRepository;

@Service
public class MemeServices {
 
	@Autowired
	private MemeRepository repository;
	
	//private List<Meme> allmemes = new ArrayList<Meme>();//Arrays.asList(new Meme(1,"name","caption","url"),new Meme(2,"name","caption","url"));
	private long latestid = 0;
	
	public Meme getMeme(long id) {
		
//		for(Meme meme:allmemes) {
//			if(meme.id == id) {
//				return meme;
//			}
//		}
		Optional<Meme> result = repository.findById(id);
	    if (result.isPresent()) {
	        return result.get();
	    } else {
	        return null;
	    }
		
		
	}
	public List<Meme> findAllMemes() {
			
//			return allmemes;
		List<Meme> allmemes = (List<Meme>) repository.findAll();
//		if(allmemes.size()>100) {
//			Collections.sort(allmemes, new SortbyId());
//			System.out.println(allmemes.get(0).id);
//			System.out.println(allmemes.get(allmemes.size()-1).id);
//			
//			return allmemes.subList(allmemes.size()-100-1, allmemes.size()-1);
//		}
		Collections.sort(allmemes, new SortbyId());
//		System.out.println(allmemes.get(0).id);
//		System.out.println(allmemes.get(allmemes.size()-1).id);
//		System.out.println(allmemes.size());
//		System.out.println(allmemes.size()-100);
		if(allmemes.size()>100)
			return allmemes.subList(0, 100);
		return allmemes;
			
	}
	
	
	public Meme addMeme(Meme meme) {
		// TODO Auto-generated method stub
		
//		System.out.println(allmemes.size());
//		meme.id=++latestid;
		return repository.save(meme);
//		allmemes.add(meme);
//		return meme.id;		
	}
	
	public long getLatestid() {
		return latestid;
	}
	public boolean updateMeme(long id,Meme meme) {
		// TODO Auto-generated method stub
//		for(Meme mymeme : allmemes) {
//			if(mymeme.id==id) {
//				mymeme.caption = meme.caption;
//				mymeme.url = meme.url;
//			}
//		}
		Meme mymeme = repository.findById(id).get();
		mymeme.caption = meme.caption;
		mymeme.url = meme.url;
		
		System.out.println(meme.caption);
		try {
	        repository.save(mymeme);
	        return true;
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        return false;
	    }
		
	}
	
 	
}
class SortbyId implements Comparator<Meme> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Meme a, Meme b) 
    { 
        return (int) (b.id - a.id); 
    } 
} 

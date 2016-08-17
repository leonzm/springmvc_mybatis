package service;

import model.Photo;

public interface PhotoService {
	
	int insert(Photo photo);
	
	Photo getUserById(String id);

}

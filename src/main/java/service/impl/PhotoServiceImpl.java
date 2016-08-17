package service.impl;

import model.Photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.PhotoService;
import dao.PhotoMapper;

@Service("photoService")
public class PhotoServiceImpl implements PhotoService {
	
	@Autowired
	private PhotoMapper photoMapper;

	@Override
	public int insert(Photo photo) {
		return photoMapper.insert(photo);
	}

	@Override
	public Photo getUserById(String id) {
		return photoMapper.selectByPrimaryKey(id);
	}

}

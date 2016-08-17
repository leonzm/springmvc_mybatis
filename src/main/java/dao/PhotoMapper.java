package dao;

import model.Photo;

public interface PhotoMapper {
    int insert(Photo record);

    Photo selectByPrimaryKey(String id);
}
package com.mzo.gestiondestock.services;

import java.io.InputStream;

import com.flickr4java.flickr.FlickrException;

public interface FlickrService {
	
	String savePhoto(InputStream photo, String titre) throws FlickrException;

}

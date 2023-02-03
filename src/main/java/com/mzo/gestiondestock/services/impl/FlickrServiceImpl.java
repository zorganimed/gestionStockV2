package com.mzo.gestiondestock.services.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.mzo.gestiondestock.services.FlickrService;

@Service
public class FlickrServiceImpl implements FlickrService{

	private Flickr flickr;
	
	@Autowired
	public FlickrServiceImpl(Flickr flickr) {
 		this.flickr = flickr;
	}



	@Override
	public String savePhoto(InputStream photo, String titre) throws FlickrException {
		UploadMetaData uploadMetaData = new UploadMetaData();
		uploadMetaData.setTitle(titre);
		
		String photoId = flickr.getUploader().upload(photo, uploadMetaData); 
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
				
	}
	
	//pertmet de se connecter à chaque fois à flickr
	/*private void connect() {
		
		flickr = new Flickr(apiKey, apiSecret, new REST());
		
		Auth auth = new Auth();
		
		auth.setPermission(Permission.DELETE);
		
		auth.setToken(appKey);
		auth.setTokenSecret(appSecret);
		
		RequestContext requestContext = RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		
		flickr.setAuth(auth);
		
	}*/

}

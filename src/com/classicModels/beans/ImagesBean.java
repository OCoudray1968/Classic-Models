package com.classicModels.beans;

public class ImagesBean {
	
	//Identifiant Image
	private Integer IdImage =0;
	// nom image
	private String NomImage ="";
	// Label de l'image
	private String LabelImage ="";
	//Tags de l'image
	private String TagsImage ="";
	
	public ImagesBean(Integer IdImage, String NomImage,String LabelImage,String TagsImage) {
		
		this.IdImage=IdImage;
		this.NomImage=NomImage;
		this.LabelImage=LabelImage;
		this.TagsImage=TagsImage;
	}
	
	public ImagesBean() {}

	public Integer getIdImage() {
		return IdImage;
	}

	public void setIdImage(Integer idImage) {
		this.IdImage = idImage;
	}

	public String getNomImage() {
		return NomImage;
	}

	public void setNomImage(String nomImage) {
		this.NomImage = nomImage;
	}

	public String getLabelImage() {
		return LabelImage;
	}

	public void setLabelImage(String labelImage) {
		this.LabelImage = labelImage;
	}

	public String getTagsImage() {
		return TagsImage;
	}

	public void setTagsImage(String tagsImage) {
		this.TagsImage = tagsImage;
	}
	
	
}

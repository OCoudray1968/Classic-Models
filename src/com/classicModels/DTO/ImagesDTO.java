package com.classicModels.DTO;

import com.classicModels.beans.ImagesBean;

public class ImagesDTO extends AbstractDTO{
	
	private Integer IdImage;
	private String NomImage;
	private String LabelImage;
	private String TagsImage;
	
public  ImagesDTO() {clear();}
	
public ImagesDTO(ImagesBean bean) {
	
		this.IdImage=bean.getIdImage();
		this.NomImage=bean.getNomImage();
		this.LabelImage=bean.getLabelImage();
		this.TagsImage=bean.getTagsImage();
		
	}
	
public void clear() {
		
		this.IdImage=0;
		this.NomImage="";
		this.LabelImage="";
		this.TagsImage="";
		
	}
	
public ImagesBean getBean() {
	
		ImagesBean bean = new ImagesBean();
		
		bean.setIdImage(getIdImage());
		bean.setNomImage(getNomImage());
		bean.setLabelImage(getLabelImage());
		bean.setTagsImage(getTagsImage());
		
	
				
		return bean;
		
	}

public String toString() {
	StringBuilder sb =new StringBuilder();
		sb.append("[ImagesDTO]\n")
			.append("id_image : ").append(this.getIdImage()).append(", \n")
			.append("nom_image : ").append(this.getNomImage()).append(",\n ")
			.append("label_image : ").append(this.getLabelImage()).append(", \n")
			.append("tags_image : ").append(this.getTagsImage()).append(", \n");
			
		return sb.toString();
					
					
}
public Integer getIdImage() {
	
	return IdImage;
}

public void setIdImage(Integer idImage) {
	
	IdImage = idImage;
}

public String getNomImage() {
	return NomImage;
}

public void setNomImage(String nomImage) {
	NomImage = nomImage;
}

public String getLabelImage() {
	return LabelImage;
}

public void setLabelImage(String labelImage) {
	LabelImage = labelImage;
}

public String getTagsImage() {
	return TagsImage;
}

public void setTagsImage(String tagsImage) {
	TagsImage = tagsImage;
}


}

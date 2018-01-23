package simpsonviewer.xfinity.com.simpsonscharacterviewer.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("Entity")
	private String entity;

	@SerializedName("DefinitionSource")
	private String definitionSource;

	@SerializedName("RelatedTopics")
	private List<RelatedTopicsItem> relatedTopics;

	@SerializedName("Heading")
	private String heading;

	@SerializedName("Abstract")
	private String Abstract;

	@SerializedName("AbstractURL")
	private String abstractURL;

	@SerializedName("DefinitionURL")
	private String definitionURL;

	@SerializedName("Definition")
	private String definition;

	@SerializedName("Redirect")
	private String redirect;

	@SerializedName("AbstractText")
	private String abstractText;

	@SerializedName("Image")
	private String image;

	@SerializedName("Infobox")
	private String infobox;

	@SerializedName("Answer")
	private String answer;

	@SerializedName("Type")
	private String type;

	@SerializedName("ImageIsLogo")
	private int imageIsLogo;

	@SerializedName("ImageHeight")
	private int imageHeight;

	@SerializedName("Results")
	private List<Object> results;

	@SerializedName("meta")
	private Meta meta;

	@SerializedName("ImageWidth")
	private int imageWidth;

	@SerializedName("AbstractSource")
	private String abstractSource;

	@SerializedName("AnswerType")
	private String answerType;

	public void setEntity(String entity){
		this.entity = entity;
	}

	public String getEntity(){
		return entity;
	}

	public void setDefinitionSource(String definitionSource){
		this.definitionSource = definitionSource;
	}

	public String getDefinitionSource(){
		return definitionSource;
	}

	public void setRelatedTopics(List<RelatedTopicsItem> relatedTopics){
		this.relatedTopics = relatedTopics;
	}

	public List<RelatedTopicsItem> getRelatedTopics(){
		return relatedTopics;
	}

	public void setHeading(String heading){
		this.heading = heading;
	}

	public String getHeading(){
		return heading;
	}

	public void setAbstract(String Abstract){
		this.Abstract = Abstract;
	}

	public String getAbstract(){
		return Abstract;
	}

	public void setAbstractURL(String abstractURL){
		this.abstractURL = abstractURL;
	}

	public String getAbstractURL(){
		return abstractURL;
	}

	public void setDefinitionURL(String definitionURL){
		this.definitionURL = definitionURL;
	}

	public String getDefinitionURL(){
		return definitionURL;
	}

	public void setDefinition(String definition){
		this.definition = definition;
	}

	public String getDefinition(){
		return definition;
	}

	public void setRedirect(String redirect){
		this.redirect = redirect;
	}

	public String getRedirect(){
		return redirect;
	}

	public void setAbstractText(String abstractText){
		this.abstractText = abstractText;
	}

	public String getAbstractText(){
		return abstractText;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setInfobox(String infobox){
		this.infobox = infobox;
	}

	public String getInfobox(){
		return infobox;
	}

	public void setAnswer(String answer){
		this.answer = answer;
	}

	public String getAnswer(){
		return answer;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setImageIsLogo(int imageIsLogo){
		this.imageIsLogo = imageIsLogo;
	}

	public int getImageIsLogo(){
		return imageIsLogo;
	}

	public void setImageHeight(int imageHeight){
		this.imageHeight = imageHeight;
	}

	public int getImageHeight(){
		return imageHeight;
	}

	public void setResults(List<Object> results){
		this.results = results;
	}

	public List<Object> getResults(){
		return results;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setImageWidth(int imageWidth){
		this.imageWidth = imageWidth;
	}

	public int getImageWidth(){
		return imageWidth;
	}

	public void setAbstractSource(String abstractSource){
		this.abstractSource = abstractSource;
	}

	public String getAbstractSource(){
		return abstractSource;
	}

	public void setAnswerType(String answerType){
		this.answerType = answerType;
	}

	public String getAnswerType(){
		return answerType;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"entity = '" + entity + '\'' + 
			",definitionSource = '" + definitionSource + '\'' + 
			",relatedTopics = '" + relatedTopics + '\'' + 
			",heading = '" + heading + '\'' + 
			",abstract = '" + Abstract + '\'' +
			",abstractURL = '" + abstractURL + '\'' + 
			",definitionURL = '" + definitionURL + '\'' + 
			",definition = '" + definition + '\'' + 
			",redirect = '" + redirect + '\'' + 
			",abstractText = '" + abstractText + '\'' + 
			",image = '" + image + '\'' + 
			",infobox = '" + infobox + '\'' + 
			",answer = '" + answer + '\'' + 
			",type = '" + type + '\'' + 
			",imageIsLogo = '" + imageIsLogo + '\'' + 
			",imageHeight = '" + imageHeight + '\'' + 
			",results = '" + results + '\'' + 
			",meta = '" + meta + '\'' + 
			",imageWidth = '" + imageWidth + '\'' + 
			",abstractSource = '" + abstractSource + '\'' + 
			",answerType = '" + answerType + '\'' + 
			"}";
		}
}
package unq.poo2.sistemaDeArchivos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public abstract class FileSystem {
	
	protected String name;
	protected Date dateCreated;
	protected Date dateModified;
	protected List<FileSystem> content = new ArrayList<FileSystem>();
	
	public String name() { 
		return this.name; 
	}

	public abstract Integer totalSize();
	public abstract void printStructure();
	
	public abstract FileSystem lastModified();
	public abstract FileSystem oldestElement();

	protected List<FileSystem> content() {
		return this.content;
	}

	protected Date dateModified() {
		return this.dateModified;
	}
	
	protected Date dateCreated() {
		return this.dateCreated;
	}

}

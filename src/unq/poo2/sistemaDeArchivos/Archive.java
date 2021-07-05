package unq.poo2.sistemaDeArchivos;

import java.util.Date;

public class Archive extends FileSystem{
	
	private Integer size;
		
	public Archive(String name, Integer size){
		this.name = name;
		this.size = size;
		this.dateCreated = new Date(System.currentTimeMillis());
		this.dateModified = this.dateCreated;
	}
	
	@Override
	public Integer totalSize() {
		return this.size;
	}

	@Override
	public Date dateModified() {
		return this.dateModified;
	}
	
	@Override
	public void printStructure() {
		System.out.println( this.name );
	}
	
	@Override
	public FileSystem lastModified() {
		return this;
	}
	
	@Override
	public FileSystem oldestElement() {
		return this;
	}
}

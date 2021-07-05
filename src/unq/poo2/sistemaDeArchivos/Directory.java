package unq.poo2.sistemaDeArchivos;

import java.util.Date;
import java.util.List;

public class Directory extends FileSystem{
	
	
	public Directory(String name){
		this.name = name;
		this.dateCreated = new Date(System.currentTimeMillis());
		this.dateModified = this.dateCreated;
	}
	
	
	public void add(FileSystem element) {
		this.content.add(element);
	}
	
	public void remove(FileSystem element) {
		this.content.remove(element);
	}
	
	public FileSystem get(Integer position) {
		return this.content.get(position);
	}	
	
	@Override
	public List<FileSystem> content() {
		return this.content;
	}

	@Override
	public Date dateCreated() {
		return this.dateCreated;
	}

	@Override
	public Integer totalSize() {
		Integer size = 0;
		for(FileSystem element:content) {
			size += element.totalSize();
		}
		return size;
	}
	
	@Override
	public void printStructure() {
		this.printStructure(this, 0);
	}
	
	@Override
	public FileSystem lastModified() {
		if(this.content().isEmpty()) {
			return this;
		}
		
		FileSystem lastFso = this.get(0).lastModified();
		FileSystem currentFso;
		
		for(FileSystem fso : this.content) {
			currentFso = fso.lastModified();
			
			if(currentFso.dateModified().after( lastFso.dateModified() ) ) {
				lastFso = currentFso;
			}
		}
		return lastFso;
	}
	
	@Override
	public FileSystem oldestElement() {
		if(this.content().isEmpty()) {
			return this;
		}
	
		FileSystem oldestFso = this.get(0).oldestElement();
		FileSystem currentFso;
			
		for(FileSystem fso : this.content) {
			currentFso = fso.oldestElement();
			
			if(currentFso.dateCreated().before( oldestFso.dateCreated() ) ) {
				oldestFso = currentFso;
			}


		}

		return oldestFso;
	}
	
	private void printStructure(FileSystem fso, Integer level) {
		String indent = this.getIndent(level);
		System.out.println( indent += fso.name );
		for(FileSystem element : fso.content() ) {
			this.printStructure(element, level + 1);
		}
	}
	
	private String getIndent(int nivel) {
		String indent = "";
		for (int i = 0; i < nivel; i++) {
			indent += " ";
		}
		return indent;
	}
	
}

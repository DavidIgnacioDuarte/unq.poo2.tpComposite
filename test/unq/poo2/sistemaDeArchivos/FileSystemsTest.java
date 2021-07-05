package unq.poo2.sistemaDeArchivos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FileSystemsTest {

	Directory root;
	Directory dir0;
	Directory dir1;
	Directory dir00;
	Directory dir01;
	Directory dir10;
	Directory dir000;
	Directory dir100;
	Archive a1;
	Archive a2;
	Archive a3;
	Archive a4;
	Archive a5;
	
	@BeforeEach
	void setUp() {
		root = new Directory("root");
		dir0 = new Directory("dir0");
		dir1 = new Directory("dir1");
		dir00 = new Directory("dir00");
		dir01 = new Directory("dir01");
		dir10 = new Directory("dir10");
		dir000 = new Directory("dir000");
		dir100 = new Directory("dir100");
		a1 = new Archive("a1",30);
		a2 = new Archive("a2",10);
		a3 = new Archive("a3",60);
		a4 = new Archive("a4",35);
		a5 = new Archive("a5",92);
		
		root.add(dir0);
		root.add(dir1);
		dir0.add(dir00);
		dir0.add(dir01);
		dir1.add(dir10);
		dir00.add(dir000);
		dir10.add(dir100);
		
		dir00.add(a1);
		dir000.add(a4);
		dir0.add(a3);
		dir1.add(a5);
		dir10.add(a2);
	}
	
	@Test
	void totalSize() {
		
		//excersice
		Integer dir00Size = dir00.totalSize();
		Integer dir01Size = dir100.totalSize();
		Integer totalSize = root.totalSize();

		//verify
		assertEquals(65, dir00Size);
		assertEquals(0, dir01Size);
		assertEquals(227, totalSize);
	}
	
	@Test
	void printStructure() {
		root.printStructure();
	}
	
	@Test
	void oldestElement() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Archive a2020 = mock(Archive.class);
		Archive a2019 = mock(Archive.class);
		try{
			when(a2020.dateCreated()).thenReturn(sdf.parse("06/12/2020"));
			when(a2019.dateCreated()).thenReturn(sdf.parse("11/03/2019"));
		} catch(Exception e){
			e.printStackTrace();
		}
			when(a2020.oldestElement()).thenReturn(a2020);
			when(a2019.oldestElement()).thenReturn(a2019);

		dir000.add(a2020);
		dir01.add(a2019);
		
		//excersice
		FileSystem fso = root.oldestElement();
		//verify
		assertEquals(a2019, fso);
	}
	
	@Test
	void lastModified() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Archive a2022 = mock(Archive.class);
		Archive a2019 = mock(Archive.class);
		try{
			when(a2022.dateModified()).thenReturn(sdf.parse("06/12/2022"));
			when(a2019.dateModified()).thenReturn(sdf.parse("11/03/2019"));
		} catch(Exception e){
			e.printStackTrace();
		}
			when(a2022.lastModified()).thenReturn(a2022);
			when(a2019.lastModified()).thenReturn(a2019);

		dir000.add(a2022);
		dir01.add(a2019);
		//excersice
		FileSystem fso = root.lastModified();
		//verify
		assertEquals(a2022, fso);
	}

}

package com.soebes.subversion.sapm;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.testng.annotations.Test;

import com.soebes.subversion.sapm.parser.SAFPLexer;
import com.soebes.subversion.sapm.parser.SAFPParser;


/**
 *
 * 
 * 

[/]
* = r

[aliases]
harry = CN=Harold Hacker,OU=Engineers,DC=red-bean,DC=com
sally = CN=Sally Swatterbug,OU=Engineers,DC=red-bean,DC=com
joe = CN=Gerald I. Joseph,OU=Engineers,DC=red-bean,DC=com

[groups]
calc-developers = &harry, &sally, &joe
paint-developers = &frank, &sally, &jane
everyone = @calc-developers, @paint-developers

[groups]
calc-developers = harry, sally, joe
paint-developers = frank, sally, jane
everyone = @calc-developers, @paint-developers

[calc:/projects/calc]
@calc-developers = rw

[paint:/projects/paint]
jane = r
@paint-developers = rw



 */
public class AppTest extends TestBase {

	@Test
	public void testReadOne() throws IOException, RecognitionException {
		FileInputStream fis = new FileInputStream(getFileResource("/svnaccess-1.conf"));
		ANTLRInputStream stream = new ANTLRInputStream(fis);
		SAFPLexer lexer = new SAFPLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SAFPParser parser = new SAFPParser(tokens);
		parser.prog();
	}

	@Test
	public void testReadTwo() throws IOException, RecognitionException {
		FileInputStream fis = new FileInputStream(getFileResource("/svnaccess-2.conf"));
		ANTLRInputStream stream = new ANTLRInputStream(fis);
		SAFPLexer lexer = new SAFPLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SAFPParser parser = new SAFPParser(tokens);
		parser.prog();
		
	}

	@Test
	public void testReadThree() throws IOException, RecognitionException {
		FileInputStream fis = new FileInputStream(getFileResource("/svnaccess-3.conf"));
		ANTLRInputStream stream = new ANTLRInputStream(fis);
		SAFPLexer lexer = new SAFPLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SAFPParser parser = new SAFPParser(tokens);
		parser.prog();
	}

	@Test
	public void testReadAST() throws IOException, RecognitionException {
		FileInputStream fis = new FileInputStream(getFileResource("/svnaccess-3.conf"));
		ANTLRInputStream stream = new ANTLRInputStream(fis);
		SAFPLexer lexer = new SAFPLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SAFPParser parser = new SAFPParser(tokens);
		SAFPParser.prog_return result = parser.prog();
		Tree t = (Tree)result.getTree();
		System.out.println("AST:" + t.toStringTree());
	}

}


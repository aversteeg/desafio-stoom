package br.com.stoom.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ResourceNotFoundExceptionTest {
	@Test(expected= ResourceNotFoundException.class) 
	public void myTest() { 
	  throw new ResourceNotFoundException();
	} 
}
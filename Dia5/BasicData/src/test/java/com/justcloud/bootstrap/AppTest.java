package com.justcloud.bootstrap;

import javax.persistence.EntityNotFoundException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.justcloud.bootstrap.app.dao.CommentDao;
import com.justcloud.bootstrap.app.dao.PersonDao;
import com.justcloud.bootstrap.app.dao.PostDao;
import com.justcloud.bootstrap.app.domain.Comment;
import com.justcloud.bootstrap.app.domain.Person;
import com.justcloud.bootstrap.app.domain.Post;


/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/spring-master.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
@Transactional
public class AppTest 
{
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private PostDao postDao;
	
	private Person person;
	private Post post;
	private Comment comment;
	
	@Before
	public void setup() {
		person = new Person();
        person.setUsername("username");
		
		post = new Post();
        post.setTitle("Prueba de post");
        post.setBody("En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos los sábados, lantejas los viernes, algún palomino de añadidura los domingos, consumían las tres partes de su hacienda. El resto della concluían sayo de velarte, calzas de velludo para las fiestas, con sus pantuflos de lo mesmo, y los días de entresemana se honraba con su vellorí de lo más fino. Tenía en su casa una ama que pasaba de los cuarenta, y una sobrina que no llegaba a los veinte, y un mozo de campo y plaza, que así ensillaba el rocín como tomaba la podadera. Frisaba la edad de nuestro hidalgo con los cincuenta años; era de complexión recia, seco de carnes, enjuto de rostro, gran madrugador y amigo de la caza. Quieren decir que tenía el sobrenombre de Quijada, o Quesada, que en esto hay alguna diferencia en los autores que deste caso escriben; aunque, por conjeturas verosímiles, se deja entender que se llamaba Quejana. Pero esto importa poco a nuestro cuento; basta que en la narración dél no se salga un punto de la verdad. ");
        person.addPostToPerson(post);
        
        comment = new Comment();
        comment.setComment("Comentario prueba");
        
        post.addCommentToPost(comment);
        personDao.save(person);
	}
	
	@After
	public void tearDown() {
		personDao.delete(person);
	}
	
	@Test
	public void testFirstPost() {
		Post p = postDao.get(1L);
		Assert.assertEquals(post.getTitle(), p.getTitle());
	}
	
	@Test
	public void testFirstComment() {
		Assert.assertEquals(1, commentDao.getAll().size());
	}
	
	@Test(expected=EntityNotFoundException.class)
	public void testNotExistent() {
		personDao.getPersonByUsername("test");
	}
	
	@Test
    public void testFindUsername() {
        person = personDao.getPersonByUsername("username");
        Assert.assertNotNull(person);
        Assert.assertEquals("username", person.getUsername());
        Assert.assertEquals(1, person.getPosts().size());
    }
}

package com.justcloud.bootstrap;

import com.justcloud.bootstrap.app.dao.CommentDao;
import com.justcloud.bootstrap.app.dao.PersonDao;
import com.justcloud.bootstrap.app.dao.PostDao;
import com.justcloud.bootstrap.app.domain.Person;
import com.justcloud.bootstrap.app.domain.Post;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author iamedu
 */
@Component
public class App {
    
    @Inject
    private PersonDao personDao;
    
    @Inject
    private CommentDao commentDao;
    
    @Inject
    private PostDao postDao;
    
    @Transactional
    public void start() {
        Person person = new Person();
        person.setUsername("username");
        person.setPassword("password");
        
        Post post = new Post();
        post.setTitle("Prueba 1");
        post.setBody("En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos los sábados, lantejas los viernes, algún palomino de añadidura los domingos, consumían las tres partes de su hacienda. El resto della concluían sayo de velarte, calzas de velludo para las fiestas, con sus pantuflos de lo mesmo, y los días de entresemana se honraba con su vellorí de lo más fino. Tenía en su casa una ama que pasaba de los cuarenta, y una sobrina que no llegaba a los veinte, y un mozo de campo y plaza, que así ensillaba el rocín como tomaba la podadera. Frisaba la edad de nuestro hidalgo con los cincuenta años; era de complexión recia, seco de carnes, enjuto de rostro, gran madrugador y amigo de la caza. Quieren decir que tenía el sobrenombre de Quijada, o Quesada, que en esto hay alguna diferencia en los autores que deste caso escriben; aunque, por conjeturas verosímiles, se deja entender que se llamaba Quejana. Pero esto importa poco a nuestro cuento; basta que en la narración dél no se salga un punto de la verdad.");
        post.setPerson(person);
        
        person.getPosts().add(post);
        
        personDao.save(person);
        postDao.indexEntity(post);
        
        System.out.println("Person saved " + person.getId());
        
        person = personDao.getPersonByUsername("username");
        System.out.println("Person found " + person.getPosts());
    }
    
    
}

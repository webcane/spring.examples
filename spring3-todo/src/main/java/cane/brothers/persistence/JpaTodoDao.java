package cane.brothers.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cane.brothers.domain.Todo;

@Repository("todoDao")
@Transactional
public class JpaTodoDao implements TodoDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addTodo(Todo todo) {
		em.persist(todo);
	}

	@Override
	public void updateTodo(Todo todo) {
		em.merge(todo);

	}

	@Override
	public Todo getTodoById(long id) {
		return em.find(Todo.class, id);
	}

}

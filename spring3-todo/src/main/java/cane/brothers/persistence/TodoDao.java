package cane.brothers.persistence;

import cane.brothers.domain.Todo;

public interface TodoDao {

	void addTodo(Todo todo);
	void updateTodo(Todo todo);
	Todo getTodoById(long id);
}

package no.foodelicious.core.repository;

import no.foodelicious.core.model.Recipe;
import org.bson.types.ObjectId;

import java.util.List;

public interface Repository<T> {
	T create(T recipe);

	T findById(ObjectId id);

	List<T> findAll();

	void delete(T recipe);
}

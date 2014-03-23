package no.foodelicious.core.repository;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;

import java.util.List;

public class CircuitBreaker<T> implements Repository<T> {

	private static final int MAX_FAILURES = 4;
	private static final long RESET_TIME = 10000L;

	enum State {OPEN, HALF_OPEN, CLOSED}

	;
	private State state = State.CLOSED;

	private int failures = 0;
	private long failedTime = 0;

	private final Repository<T> delegate;

	public CircuitBreaker(Repository<T> delegate) {
		this.delegate = delegate;
	}

	@Override
	public T create(T object) {
		return doTry((o) -> delegate.create(o), object);
	}

	@Override
	public T findById(ObjectId id) {
		return doTry((o) -> delegate.findById(o), id);
	}

	@Override
	public List<T> findAll() {
		return doTry(delegate::findAll, null);
	}

	@Override
	public void delete(T object) {
		doTry((o) -> {
			delegate.delete(o);
			return null;
		}, object);
	}

	private <ReturnType, ParamType> ReturnType doTry(DoTryHard<ParamType, ReturnType> function, ParamType parameter) {
		if (state == State.OPEN) {
			checkFailTime();
			throw new IllegalStateException("Repository currently offline, please try again later");
		}
		ReturnType result = null;
		try {
			result = function.act(parameter);
		} catch (Exception e) {
			registerFailure();
			throw new IllegalStateException("Repository currently offline", e);
		}
		registerSuccess();
		return result;
	}

	private void registerSuccess() {
		failures = 0;
		state = State.CLOSED;
	}

	private void registerFailure() {
		failures++;
		if (failures > MAX_FAILURES) {
			state = State.OPEN;
			failedTime = new DateTime().getMillis();
		}
	}

	private void checkFailTime() {
		if (new DateTime().getMillis() - failedTime > RESET_TIME) {
			failures = MAX_FAILURES;
			state = State.HALF_OPEN;
		}
	}

	@FunctionalInterface
	private interface DoTryHard<ParamType, ReturnType> {
		ReturnType act(ParamType a);
	}
}
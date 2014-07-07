package no.foodelicious.core.health;

import com.codahale.metrics.health.HealthCheck;
import com.mongodb.Mongo;

public class MongoHealth extends HealthCheck {

	private Mongo mongo;
	
	public MongoHealth(Mongo name) {
		super();
	}

	@Override
	protected Result check() throws Exception {
		mongo.getDatabaseNames();
		return Result.healthy();
	}
}

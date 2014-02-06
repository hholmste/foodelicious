package no.foodelicious.core.health;

import com.mongodb.Mongo;
import com.yammer.metrics.core.HealthCheck;

public class MongoHealth extends HealthCheck {

	private Mongo mongo;
	
	public MongoHealth(Mongo name) {
		super("MongoDBHealthCheck");
	}

	@Override
	protected Result check() throws Exception {
		mongo.getDatabaseNames();
		return Result.healthy();
	}
}

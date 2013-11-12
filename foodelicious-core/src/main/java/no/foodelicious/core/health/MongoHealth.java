package no.foodelicious.core.health;

import com.yammer.metrics.core.HealthCheck;

public class MongoHealth extends HealthCheck {

	public MongoHealth(String name) {
		super(name);
	}

	@Override
	protected Result check() throws Exception {
		return Result.healthy("mongodb - ok");
	}
}
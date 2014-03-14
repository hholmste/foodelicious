package no.foodelicious.core.matchers;

import no.foodelicious.core.model.Recipe;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class RecipeMatcher {

	public static Matcher<Recipe> isEqualTo(final Recipe a) {
		return new TypeSafeMatcher<Recipe>() {

			@Override
			public void describeTo(Description description) {
				description.appendValue(a);
			}

			@Override
			protected boolean matchesSafely(Recipe b) {
				if(
						StringUtils.equals(a.getName(), b.getName()) &&
						StringUtils.equals(a.getDescription(), b.getDescription()) &&
						StringUtils.equals(a.getDirections(), b.getDirections()) &&
						StringUtils.equals(a.getSource(), b.getSource()) &&
						a.getCourseType() == b.getCourseType() &&
						a.getServings() == b.getServings())
					return true;
				else {
					return false;
				}
			}
		};
	}
}

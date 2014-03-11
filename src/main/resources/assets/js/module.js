var recipeApp = angular.module('recipeApp', [
	'ngRoute',
	'recipeController'
]);

recipeApp.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider
			.when('/recipes', {
				templateUrl: 'views/partials/recipe_overview.html'
			})
			.when('/recipes/:recipeId', {
				templateUrl: 'views/partials/recipe_detail.html'
			})
			.when('/new', {
				templateUrl: 'views/partials/recipe_new.html'
			})
			.otherwise({
				redirectTo: '/recipes'
			});
	}]);
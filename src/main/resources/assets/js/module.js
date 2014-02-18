var recipeApp = angular.module('recipeApp', [
	'ngRoute',
	'recipeController'
]);

recipeApp.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider
			.when('/recipes', {
				templateUrl: '/views/partials/recipe_overview.html'
			})
			.when('/new', {
				templateUrl: '/views/partials/recipe_detail.html'
			})
			.otherwise({
				redirectTo: '/recipes'
			});
	}]);
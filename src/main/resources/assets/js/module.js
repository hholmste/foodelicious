var recipeApp = angular.module('recipeApp', [
	'ngRoute',
	'ngSanitize',
	'recipeController'
]);

recipeApp.config(['$routeProvider','$locationProvider',
	function($routeProvider,$locationProvider) {
		$locationProvider.html5Mode(true);
		$routeProvider
			.when('/recipes', {
				templateUrl: 'views/partials/recipe_overview.html',
				controller: 'RecipeCtrl'
			})
			.when('/recipes/:recipeId', {
				templateUrl: 'views/partials/recipe_detail.html',
				controller: 'RecipeDetailCtrl'
			})
			.when('/new', {
				templateUrl: 'views/partials/recipe_new.html'
			})
			.otherwise({
				redirectTo: '/recipes'
			});
	}]);
var recipeControllers = angular.module('recipeControllers', []);

recipeControllers.controller('RecipeCtrl', ['$scope', '$http',
	function($scope, $http) {
		$http.get('http://localhost:8080/foodelicious/recipe').
		success(function(data) {
			$scope.recipes = data
		}).
		error(function(data) {
			// default
			$scope.recipes = [
				{'name': 'receipname1',
				 'description': 'receipdescription1'},
				{'name': 'receipname2',
				 'description': 'receipdescription2'},
			];
		});
	}]);
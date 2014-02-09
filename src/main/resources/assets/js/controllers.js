var recipeControllers = angular.module('recipeControllers', []);

recipeControllers.controller('RecipeCtrl', function($scope) {
	$scope.recipes = [
		{'name': 'receipname1',
		 'description': 'receipdescription1'},
		{'name': 'receipname2',
		 'description': 'receipdescription2'},
	];
});
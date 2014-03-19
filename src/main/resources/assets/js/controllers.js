var recipeController = angular.module('recipeController', []);

recipeController.controller('RecipeCtrl', ['$scope', '$http','$location',
	function($scope, $http, $location) {
		$http.get('foodelicious/recipe').
		success(function(data) {
			$scope.recipes = data;
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

		$scope.courseTypes = [
			{name:'Starter', code:'STARTER'},
			{name:'Main course', code:'MAIN_COURSE'},
			{name:'Dessert', code:'DESSERT'}
		];

		$scope.saveRecipe = function(recipe) {
			$http.post('foodelicious/recipe', recipe).
			success(function(data) {
				$scope.statusText = 'Saved';
				$location.path('foodelicious/recipes');
			}).
			error(function(data) {
				$scope.statusText = 'Error saving';
			});
		};
	}
]);

recipeController.controller('RecipeDetailCtrl', ['$scope', '$http', '$routeParams',
	function($scope, $http, $routeParams) {
		$http.get('foodelicious/recipe/' + $routeParams.recipeId).
		success(function(data) {
			$scope.recipe = data;
		}).
		error(function(data) {
			// default
			$scope.name = 'Name not found';
		});
	}
]);

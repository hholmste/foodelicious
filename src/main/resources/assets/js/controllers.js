var recipeController = angular.module('recipeController', []);

recipeController.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

recipeController.service('fileUpload', ['$http', function ($http) {
	return {
		async: function(file, uploadUrl){
        var fd = new FormData();
        fd.append('file', file);
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(data){
        	return data;
        })
        .error(function(){
        	console.log('error saving file!')
        });
	}
};
}]);

recipeController.controller('RecipeCtrl', ['$scope', '$http','$location', 'fileUpload',
	function($scope, $http, $location, fileUpload) {
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

			var file = $scope.image;
			var uploadUrl = 'foodelicious/image';

			var fd = new FormData();
	        fd.append('file', file);
	        $http.post(uploadUrl, fd, {
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	        })
	        .success(function(data){
	        	//recipe.imageId = 'gggggg';
	        	var recipe1 = recipe;
	        	recipe1.imageId = data;
				$http.post('foodelicious/recipe', recipe1).
					success(function(data) {
						$scope.statusText = 'Recipe saved';
						$location.path('foodelicious/recipes');
					}).
					error(function(data) {
						$scope.statusText = 'Error saving';
					});
	        })
	        .error(function(){
	        	$scope.statusText = 'Error saving image';
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
			$scope.name = 'Name not found';
		});
	}
]);
